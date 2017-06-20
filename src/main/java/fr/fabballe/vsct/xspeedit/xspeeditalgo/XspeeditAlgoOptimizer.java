package fr.fabballe.vsct.xspeedit.xspeeditalgo;

import fr.fabballe.vsct.xspeedit.xspeeditalgo.pojo.Article;
import fr.fabballe.vsct.xspeedit.xspeeditalgo.pojo.Box;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Inspiré de : https://fr.wikipedia.org/wiki/Probl%C3%A8me_de_bin_packing
 * Created by fabballe on 20/06/17.
 */
public class XspeeditAlgoOptimizer {


    /**
     * Optimize the list of article (String input) with the max weight per box value
     *
     * @param inputArticle      the list of article
     * @param nbMaxWeightPerBox the max weight per box
     * @return a list of box
     */
    public static List<Box> optimizeArticlePerBox(String inputArticle, Integer nbMaxWeightPerBox) {

        List<Article> articles = extractAndOrderArticle(inputArticle);

        return generateBoxesFromArticles(nbMaxWeightPerBox, articles);

    }

    /**
     * Generate the optimized list of box for a list of article and a max weight per box
     *
     * @param nbMaxWeightPerBox the max weight per box
     * @param articles          the list of article
     * @return the optimized list of box
     */
    private static List<Box> generateBoxesFromArticles(Integer nbMaxWeightPerBox, List<Article> articles) {
        List<Box> optimizedListBox = new ArrayList<>();

        articles.stream().forEach(article -> {
            // We get the first box we can use. Because it's order from biggest sum weight to smallest we get the first usable box with max weight
            Optional<Box> destinationBox = getFirstUsableBox(optimizedListBox, article);

            // We add the article on the current box or create one if doesn't exist
            if (destinationBox.isPresent()) {
                destinationBox.get().addArticleIntoBox(article);
            } else {
                Box newBox = new Box(nbMaxWeightPerBox);
                newBox.addArticleIntoBox(article);
                optimizedListBox.add(newBox);
            }
        });

        return optimizedListBox;
    }

    /**
     * Return the first box where we can put the article inside
     *
     * @param optimizeBoxes the list of box
     * @param article       the article to put inside
     * @return the first box where we can add the article inside
     */
    private static Optional<Box> getFirstUsableBox(List<Box> optimizeBoxes, Article article) {
        return optimizeBoxes
                .stream()
                        // in order to optimized the algorithm we need to first sort the list. In this way we are sur to catch the biggest box which we can add the article inside
                .sorted((box1, box2) -> box2.sumArticleWeight().compareTo(box1.sumArticleWeight()))
                .filter(box -> !box.isFull() && box.sumArticleWeight() + article.getWeight() <= box.getMaxWeight())
                .findFirst();
    }

    /**
     * Split the article input into an order list of article (by biggest weight first)
     *
     * @param inputArticle the article input
     * @return the list of article sorted
     */
    public static List<Article> extractAndOrderArticle(String inputArticle) {
        String[] dividedInput = inputArticle.split("");

        return Arrays.stream(dividedInput)
                .parallel()
                        // we convert each input into an article object
                .map(weight -> new Article(Integer.valueOf(weight)))
                        // we sort the stream in order to have biggest weight first
                .sorted((article1, article2) -> article2.getWeight().compareTo(article1.getWeight()))
                .collect(Collectors.toList());
    }

    /**
     * Transform the list of box into a string representation
     *
     * @param optimizedListBox the list of box
     * @return a string representation of the of box
     */
    public static String formatListBoxToOutput(List<Box> optimizedListBox) {
        return optimizedListBox.parallelStream()
                .map(Box::toString)
                .collect(Collectors.joining("/"));
    }
}

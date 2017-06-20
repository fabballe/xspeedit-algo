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


    public static List<Box> optimizeArticlePerBox(String inputArticle, Integer nbMaxWeightPerBox) {

        List<Article> articles = extractAndOrderArticle(inputArticle);

        return generateBoxesFromArticles(nbMaxWeightPerBox, articles);

    }

    private static List<Box> generateBoxesFromArticles(Integer nbMaxWeightPerBox, List<Article> articles) {
        List<Box> optimizedListBox = new ArrayList<>();

        articles.stream().forEach(article -> {
            // We get the first box we can use. Because it's order from biggest sum weidth to smallest we get the first usable box with max weight
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

    private static Optional<Box> getFirstUsableBox(List<Box> optimizeBoxes, Article article) {
        return optimizeBoxes
                .stream()
                .filter(box -> !box.isFull() && box.sumArticleWeigth() + article.getWeight() <= box.getMaxWeight())
                .findFirst();
    }

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


    public static String formatListBoxToOutput(List<Box> optimizedListBox) {
        return optimizedListBox.parallelStream()
                .map(Box::toString)
                .collect(Collectors.joining("/"));
    }
}

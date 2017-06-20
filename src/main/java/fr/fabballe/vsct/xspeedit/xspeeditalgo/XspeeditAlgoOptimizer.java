package fr.fabballe.vsct.xspeedit.xspeeditalgo;

import fr.fabballe.vsct.xspeedit.xspeeditalgo.pojo.Article;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Inspiré de : https://fr.wikipedia.org/wiki/Probl%C3%A8me_de_bin_packing
 * Created by fabballe on 20/06/17.
 */
public class XspeeditAlgoOptimizer {


    public static String optimizeArticlePerBox(String inputArticle, Integer nbMaxPerBox) {


        List<Article> articles = extractAndOrderArticle(inputArticle);

        articles.stream()
                .map(article -> {
                            System.out.println("article.getWeight() = " + article.getWeight());
                            return article;
                        }
                ).collect(Collectors.toList());


        return "TOOD";
    }

    public static List<Article> extractAndOrderArticle(String inputArticle) {
        String[] dividedInput = inputArticle.split("");

        return Arrays.stream(dividedInput)
                    .parallel()
                    // we convert each input into an article object
                    .map(weidth -> new Article(Integer.valueOf(weidth)))
                    // we sort the stream in order to have biggest weidth first
                    .sorted((article1, article2) -> article2.getWeight().compareTo(article1.getWeight()))

                    .collect(Collectors.toList());
    }


}

package fr.fabballe.vsct.xspeedit.xspeeditalgo;

public class XspeeditAlgoApplication {

    public static void main(String[] args) {

        String inputArticle = args[0];

        String optimizedArticle = XspeeditAlgoOptimizer.optimizeArticlePerBox(inputArticle);

        System.out.println("optimizedArticle = " + optimizedArticle);

    }
}

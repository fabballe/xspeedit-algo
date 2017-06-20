package fr.fabballe.vsct.xspeedit.xspeeditalgo;

public class XspeeditAlgoApplication {

    public static void main(String[] args) {

        String inputArticle = args[0];
//        Integer nbMaxPerBox = Integer.valueOf(args[1]);

        Integer nbMaxPerBox = 10;

        String optimizedArticle = XspeeditAlgoOptimizer.optimizeArticlePerBox(inputArticle, nbMaxPerBox);

        System.out.println("optimizedArticle = " + optimizedArticle);

    }
}

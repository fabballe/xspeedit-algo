package fr.fabballe.vsct.xspeedit.xspeeditalgo;

import fr.fabballe.vsct.xspeedit.xspeeditalgo.pojo.Box;

import java.util.List;

public class XspeeditAlgoApplication {

    public static void main(String[] args) {

        //check input data
        if(args.length != 2)
        {
            System.out.println("Proper Usage is: java -jar xspeedit-algo-0.0.1-SNAPSHOT.jar inputArticle nbMaxWeightPerBox");
            System.exit(0);
        }

        String inputArticle = args[0];
        Integer nbMaxWeightPerBox = Integer.valueOf(args[1]);

        // optimize box list
        List<Box> optimizedListBox =  XspeeditAlgoOptimizer.optimizeArticlePerBox(inputArticle, nbMaxWeightPerBox);

        // Format for output
        String result = XspeeditAlgoOptimizer.formatListBoxToOutput(optimizedListBox);

        System.out.println("result = " + result);
    }
}

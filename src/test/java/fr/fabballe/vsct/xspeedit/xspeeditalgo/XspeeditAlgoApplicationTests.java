package fr.fabballe.vsct.xspeedit.xspeeditalgo;

import fr.fabballe.vsct.xspeedit.xspeeditalgo.pojo.Article;
import fr.fabballe.vsct.xspeedit.xspeeditalgo.pojo.Box;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@RunWith(BlockJUnit4ClassRunner.class)
public class XspeeditAlgoApplicationTests {

    @Test
    public void testExtractAndOrderArticle(){
        String inputArticle = "163841689525773";
        List<Article> sortedArticle = XspeeditAlgoOptimizer.extractAndOrderArticle(inputArticle);

        Assert.assertEquals("We need to have " + inputArticle.length()+ " articles", inputArticle.length(), sortedArticle.size());

        // we check that the list is in the correct order (biggest weight first)
        IntStream.range(0, sortedArticle.size()-1)
                .allMatch(i -> sortedArticle.get(i).getWeight().compareTo(sortedArticle.get(i+1).getWeight()) > 0);
    }

    @Test
    public void testOptimisation1() {
        String inputArticle = "163841689525773";

        List<Box> optimizedListBox = XspeeditAlgoOptimizer.optimizeArticlePerBox(inputArticle, 10);

        Assert.assertEquals("We need to have 8 box", 8, optimizedListBox.size());

        // we check that all box have a total weigth under the limit
        IntStream.range(0, optimizedListBox.size()-1)
                .allMatch(i -> optimizedListBox.get(i).sumArticleWeight() <= 10);
    }

    @Test
    public void testOptimisation2() {
        String inputArticle = "33344";

        List<Box> optimizedListBox = XspeeditAlgoOptimizer.optimizeArticlePerBox(inputArticle, 10);

        Assert.assertEquals("We need to have 2 box", 2, optimizedListBox.size());

        // we check that all box have a total weigth under the limit
        IntStream.range(0, optimizedListBox.size()-1)
                .allMatch(i -> optimizedListBox.get(i).sumArticleWeight() <= 10);
    }

    @Test
    public void testFormatListBoxToOutput(){
        List<Box> boxes = new ArrayList<>();
        Box firstBox = new Box(10);
        firstBox.addArticleIntoBox(new Article(8));
        firstBox.addArticleIntoBox(new Article(1));

        Box secondBox = new Box(10);
        secondBox.addArticleIntoBox(new Article(3));
        secondBox.addArticleIntoBox(new Article(4));
        secondBox.addArticleIntoBox(new Article(3));

        Box thirdBox = new Box(10);
        thirdBox.addArticleIntoBox(new Article(7));
        thirdBox.addArticleIntoBox(new Article(3));

        boxes.add(firstBox);
        boxes.add(secondBox);
        boxes.add(thirdBox);

        String expectedResult = "81/343/73";

        String output = XspeeditAlgoOptimizer.formatListBoxToOutput(boxes);

        Assert.assertEquals("Values should be equals", expectedResult, output);
    }
}

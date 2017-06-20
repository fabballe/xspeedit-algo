package fr.fabballe.vsct.xspeedit.xspeeditalgo;

import fr.fabballe.vsct.xspeedit.xspeeditalgo.pojo.Article;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

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
        String expectedResult = "163/82/46/19/8/55/73/7";

        String optimizedArticle = XspeeditAlgoOptimizer.optimizeArticlePerBox(inputArticle, 10);

        Assert.assertEquals("Les valeurs doivent etre identiques", expectedResult, optimizedArticle);

    }
}

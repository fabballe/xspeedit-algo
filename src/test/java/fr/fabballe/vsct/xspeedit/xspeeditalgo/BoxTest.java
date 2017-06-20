package fr.fabballe.vsct.xspeedit.xspeeditalgo;

import fr.fabballe.vsct.xspeedit.xspeeditalgo.pojo.Article;
import fr.fabballe.vsct.xspeedit.xspeeditalgo.pojo.Box;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * Created by fabballe on 20/06/17.
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class BoxTest {

    @Test
    public void testIsFull(){
        Box boxNotFull = new Box(10);

        boxNotFull.addArticleIntoBox(new Article(5));
        Assert.assertFalse("The box need to be 'not full'", boxNotFull.isFull());

        boxNotFull.addArticleIntoBox(new Article(4));
        Assert.assertFalse("The box still need to be 'not full'", boxNotFull.isFull());

        boxNotFull.addArticleIntoBox(new Article(1));
        Assert.assertTrue("The box need to be 'full'", boxNotFull.isFull());
    }

    @Test
    public void testSumArticleWeidth(){
        Box box = new Box(10);

        box.addArticleIntoBox(new Article(5));
        Assert.assertEquals("Sum article weidth need to be 5", Integer.valueOf(5), box.sumArticleWeight());

        box.addArticleIntoBox(new Article(4));
        Assert.assertEquals("Sum article weidth need to be 9", Integer.valueOf(9), box.sumArticleWeight());

        box.addArticleIntoBox(new Article(1));
        Assert.assertEquals("Sum article weidth need to be 10", Integer.valueOf(10), box.sumArticleWeight());
    }
}

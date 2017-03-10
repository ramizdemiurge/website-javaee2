package Models.dbclasses;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;


public class ArticleTest
{
    @Test
    public void initArticles() throws Exception
    {
        ArrayList<Article> testArticles;

        testArticles = Article.InitArticles();
        Iterator<Article> iter = testArticles.iterator();

        if (iter.hasNext())
        {
            System.out.println(iter.next());
        }

//        for (Article sdfdf:testArticles)
//        {
//            System.out.println(sdfdf);
//        }

        Assert.assertTrue(iter.hasNext());
    }

    @Test
    public void InitArticle() throws Exception
    {
        Article testArticle = new Article();

        Assert.assertEquals(testArticle.getAuthor(),"System");
        Assert.assertEquals(testArticle.getLead_text(),"");

        testArticle = Article.InitArticle(new Article(1));

        Assert.assertNotEquals(testArticle.getAuthor(),"System");
        Assert.assertNotEquals(testArticle.getLead_text(),"");

    }
}

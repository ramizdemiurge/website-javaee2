package Models.dbclasses;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;


public class ArticlesTest
{
    @Test
    public void initArticle() throws Exception
    {
        ArrayList<Articles> testArticles;

        testArticles = Articles.InitArticles();
        Iterator<Articles> iter = testArticles.iterator();

        if (iter.hasNext())
        {
            System.out.println(iter.next());
        }

//        for (Articles sdfdf:testArticles)
//        {
//            System.out.println(sdfdf);
//        }

        Assert.assertTrue(iter.hasNext());
    }

    @Test
    public void InitArticles() throws Exception
    {

    }
}

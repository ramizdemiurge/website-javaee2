package Models.dbclasses;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;


public class ArticlesTest
{
    @Test
    public void initArticles() throws Exception
    {
        ArrayList<Articles> testArticles;

        testArticles = Articles.InitArticles();
        Iterator<Articles> iter = testArticles.iterator();

        Assert.assertTrue(iter.hasNext());

        if (iter.hasNext())
        {
            System.out.println(iter.next());
        }

//        for (Articles sdfdf:testArticles)
//        {
//            System.out.println(sdfdf);
//        }
    }
}
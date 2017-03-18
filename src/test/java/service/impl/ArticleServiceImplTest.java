package service.impl;

import config.DataConfig;
import entity.Article;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.ArticleService;

/**
 * Created by allard on 3/18/17.
 */
public class ArticleServiceImplTest
{
    @Test
    public void getById() throws Exception
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(DataConfig.class);
        ArticleService articleService = context.getBean(ArticleService.class);

        Article article = articleService.getById(1);

        System.out.println(article.getLead_text());
    }

}
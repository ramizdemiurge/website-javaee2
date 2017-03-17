package service;

import entity.Article;

import java.util.List;

public interface ArticleService
{
    Article addArticle(Article article);
    void delete(long id);
    Article getById(long id);
    Article editArticle(Article article);
    List<Article> getAll();
}

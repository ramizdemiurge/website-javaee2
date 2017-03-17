package service.impl;

import entity.Article;
import repository.ArticleRepository;
import service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService
{
    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Article addArticle(Article article)
    {

        Article savedArticle = articleRepository.saveAndFlush(article);
        return savedArticle;
    }

    @Override
    public void delete(long id)
    {
        articleRepository.delete(id);
    }

    @Override
    public Article getById(long id)
    {
        return articleRepository.findById(id);
    }

    @Override
    public Article editArticle(Article article)
    {
        return articleRepository.saveAndFlush(article);
    }

    @Override
    public List<Article> getAll()
    {
        return articleRepository.findAll();
    }
}

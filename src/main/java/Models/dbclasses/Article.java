package Models.dbclasses;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Article
{
    private int id;
    private String title;
    private String author;
    private Date date;
    private boolean sandbox;
    private String text;
    private String lead_text;

    public Article()
    {
        this.setTitle("Error 404");
        this.setLead_text("");
        this.setText("There's no article with this id.");
        this.setAuthor("System");
        this.setDate(new Date());
    }
    public Article(int id)
    {
        this();
        this.setId(id);
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public boolean isSandbox()
    {
        return sandbox;
    }

    public void setSandbox(boolean sandbox)
    {
        this.sandbox = sandbox;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    @Override
    public String toString()
    {
        String temp = "";
        temp += getTitle() + "\n";
        temp += getText();
        return temp;
    }

    public String getLead_text()
    {
        return lead_text;
    }

    public void setLead_text(String lead_text)
    {
        this.lead_text = lead_text;
    }

    public static ArrayList<Article> InitArticles()
    {
        ArrayList<Article> articles = new ArrayList<Article>();

        DBWorker worker = new DBWorker();
        String query = "select * from articles";
        try
        {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next())
            {
                Article temp = new Article();

                temp.setId(resultSet.getInt("id"));
                temp.setTitle(resultSet.getString("title"));
                temp.setAuthor(resultSet.getString("author"));
                temp.setDate(resultSet.getDate("date"));
                temp.setSandbox(resultSet.getBoolean("sandbox"));
                temp.setText(resultSet.getString("text"));
                temp.setLead_text(resultSet.getString("lead_text"));

                articles.add(temp);
            }
        } catch (SQLException Exception)
        {
            System.err.print(Exception);
        }
        Collections.reverse(articles);
        return articles;
    }

    public static Article InitArticle(Article article)
    {
        DBWorker worker = new DBWorker();
        String query = "select * from articles WHERE id=\"" + article.getId() + "\"";
        try
        {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next())
            {
                article.setTitle(resultSet.getString("title"));
                article.setAuthor(resultSet.getString("author"));
                article.setDate(resultSet.getDate("date"));
                article.setSandbox(resultSet.getBoolean("sandbox"));
                article.setText(resultSet.getString("text"));
                article.setLead_text(resultSet.getString("lead_text"));
            }
        } catch (SQLException Exception)
        {
            System.err.print(Exception);
        }
        return article;
    }
}

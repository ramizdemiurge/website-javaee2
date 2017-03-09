package Models.dbclasses;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class Articles
{
    private int id;
    private String title;
    private String author;
    private Date date;
    private boolean sandbox;
    private String text;
    private String lead_text;

    public static ArrayList<Articles> InitArticles()
    {
        ArrayList<Articles> articles = new ArrayList<Articles>();

        DBWorker worker = new DBWorker();
        String query = "select * from articles";
        try
        {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next())
            {
                Articles temp = new Articles();

                temp.setId(resultSet.getInt("id"));
                temp.setTitle(resultSet.getString("title"));
                temp.setAuthor(resultSet.getString("author"));
                temp.setDate(resultSet.getDate("date"));
                temp.setSandbox(resultSet.getBoolean("sandbox"));
                temp.setText(resultSet.getString("text"));
                temp.setLead_text(resultSet.getString("lead_text"));

                articles.add(temp);
            }
        } catch (SQLException Exception1)
        {
            System.err.print(Exception1);
        }
        return articles;
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
        temp+=getTitle()+"\n";
        temp+=getText();
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
}

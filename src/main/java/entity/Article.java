package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "articles")
public class Article
{
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id", length = 6, nullable = false)
    private long id;

    @Column(name = "title")
    private String title;


    @Column(name = "author")
    private String author;


    @Column(name = "date")
    private Date date;


    @Column(name = "sandbox")
    private String sandbox;


    @Column(name = "text")
    private String text;


    @Column(name = "lead_text")
    private String lead_text;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
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

    public String getSandbox()
    {
        return sandbox;
    }

    public void setSandbox(String sandbox)
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

    public String getLead_text()
    {
        return lead_text;
    }

    public void setLead_text(String lead_text)
    {
        this.lead_text = lead_text;
    }
}

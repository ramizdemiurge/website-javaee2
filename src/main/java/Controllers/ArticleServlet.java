package Controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ArticleServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
//
//        String string_id = req.getParameter("id");
//        if (string_id != null)
//        {
//            int id = Integer.parseInt(string_id.trim());
//            Article article;
//            article = Article.InitArticle(new Article(id));
//            req.getSession().setAttribute("article", article);
//            getServletContext().getRequestDispatcher("/View/article_get.jsp").forward(req, resp);
//
//        } else
//        {
//            req.getSession().setAttribute("messages", "There is no such article");
//            resp.sendRedirect("/index.html");
//        }
    }
}
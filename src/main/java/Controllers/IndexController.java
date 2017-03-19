package Controllers;

import Models.Methods;
import Models.dbclasses.Article;
import config.DataConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@Controller
@RequestMapping("/")
public class IndexController
{
    @RequestMapping(value = "/index.html",method = RequestMethod.GET)
    public String printWelcome(HttpServletRequest req)
    {
        //req.getSession().removeAttribute("messages");
        String string_id = req.getParameter("article");
        if (string_id != null)
        {
            int id = Integer.parseInt(string_id.trim());
            Article article;
            article = Article.InitArticle(new Article(id));
            req.getSession().setAttribute("article", article);
            return "article_get";
        }
            ArrayList<Article> articleList;
            articleList = Article.InitArticles();
            req.getSession().setAttribute("articles",articleList);
        return "index_get";
    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    public void RedirToIndex(HttpServletResponse resp) throws IOException
    {
        resp.sendRedirect("/index.html");
    }

    @RequestMapping(value="/index.html", method=RequestMethod.POST)
    public String greetingSubmit(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        HttpSession mySession = req.getSession();
        String login = req.getParameter("login").trim().toLowerCase();
        String passwd = req.getParameter("passwd");

        if (!(Methods.EmptyStringDetector(login,passwd)))
        {
            ApplicationContext context = new AnnotationConfigApplicationContext(DataConfig.class);
            UserService userService = context.getBean(UserService.class);
            entity.User user = userService.getByUsername(login);


            if (user.getPassword().equals(passwd))
            {
                mySession.setAttribute("username", user.getUsername());
                mySession.setAttribute("passwd", user.getPassword());
                req.getSession().removeAttribute("messages");
                resp.sendRedirect("/home");

            } else
            {
                mySession.setAttribute("messages","Correct your login/password.");
                mySession.removeAttribute("username");
                mySession.removeAttribute("password");
                resp.sendRedirect("/index.html");
            }
        } else
        {
            req.getSession().setAttribute("messages","Enter your login and password.");
            resp.sendRedirect("/index.html");
        }
        return "index_get";
    }
}
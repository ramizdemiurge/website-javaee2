package Controllers;

import Models.dbclasses.Article;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
@RequestMapping("/")
public class IndexController
{
    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(HttpServletRequest req)
    {
        ArrayList<Article> articleList;
        articleList = Article.InitArticles();
        req.getSession().setAttribute("articles",articleList);
        return "index_get";
    }
    @RequestMapping(value="/index.html", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute IndexController greeting, Model model) {
        model.addAttribute("greeting", greeting);
        return "result";
    }
}

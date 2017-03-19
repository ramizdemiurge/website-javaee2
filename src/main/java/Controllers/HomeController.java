package Controllers;

import config.DataConfig;
import entity.User;
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

@Controller
@RequestMapping("/home")
public class HomeController
{
    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        HttpSession mySession = req.getSession();
        User catched_user = (User) mySession.getAttribute("user");
        if (catched_user != null)
        {
            ApplicationContext context = new AnnotationConfigApplicationContext(DataConfig.class);
            UserService userService = context.getBean(UserService.class);
            User user = userService.getByUsername(catched_user.getUsername());
            if (user != null)
            {
                if (user.getPassword().equals(catched_user.getPassword()))
                {
                    mySession.setAttribute("user", user);
                    return "home_get";
                } else
                {
                    req.getSession().setAttribute("messages", "Correct your login/password.");
                    resp.sendRedirect("/index.html");
                }
            }
        }
        resp.sendRedirect("/index.html");
        return null;
    }
}

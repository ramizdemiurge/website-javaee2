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
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/users.html")
public class UserlistController
{
    @RequestMapping(method = RequestMethod.GET)
    public String printUsers(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(DataConfig.class);
        UserService userService = context.getBean(UserService.class);

        String string_login = req.getParameter("login");
        if (string_login != null)
        {
            User user = userService.getByUsername(string_login);
            if (user != null)
            {
                req.getSession().setAttribute("user_info", user);
                return "user_get";
            }
            else
            {
                //Send 404 Error
                return null;
            }
        }
            List<User> users;
            users = userService.getAll();
            req.getSession().setAttribute("users",users);
            return "userlist_get";
    }
}

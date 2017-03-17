package Controllers;

import Models.UserModel.User;
import Models.dbclasses.DBWorker;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by allard on 3/17/17.
 */
@Controller
@RequestMapping("/users.html")
public class UserlistController
{
    @RequestMapping(method = RequestMethod.GET)
    public String printUsers(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        String string_login = req.getParameter("login");
        if (string_login != null)
        {
            User user;
            user = DBWorker.InitUser(new User(string_login));
            if (user.getUsername() != null)
            {
                req.getSession().setAttribute("user", user);
                return "user_get";
            }
            else
            {
                //Send 404 Error
                return null;
            }
        }
            ArrayList<User> users;
            users = DBWorker.InitUsers();
            req.getSession().setAttribute("users",users);
            return "userlist_get";
    }
}

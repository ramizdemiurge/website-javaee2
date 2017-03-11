package Controllers;

import Models.UserModel.User;
import Models.dbclasses.DBWorker;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class UserlistServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        String string_login = req.getParameter("login");
        if (string_login != null)
        {
            User user;
            user = DBWorker.InitUser(new User(string_login));
            if (user.getUsername() != null)
            {
                req.getSession().setAttribute("user", user);
                getServletContext().getRequestDispatcher("/View/user_get.jsp").forward(req, resp);
            }
            else
            {
                getServletContext().getRequestDispatcher("/View/errorpages/404.jsp").forward(req, resp);
            }
        } else
        {
            ArrayList<User> users;
            users = DBWorker.InitUsers();
            req.getSession().setAttribute("users",users);
            getServletContext().getRequestDispatcher("/View/userlist_get.jsp").forward(req, resp);

        }
        req.getSession().removeAttribute("messages");

      }

}

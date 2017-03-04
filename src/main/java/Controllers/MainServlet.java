package Controllers;

import Models.Methods;
import Models.UserModel.User;
import Models.dbclasses.DBWorker;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by adsf on 10.01.2017.
 */
public class MainServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        getServletContext().getRequestDispatcher("/View/index_get.jsp").forward(req, resp);
        req.getSession().removeAttribute("messages");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        HttpSession mySession = req.getSession();
        String login = req.getParameter("login").trim().toLowerCase();
        String passwd = req.getParameter("passwd");

        if (!(Methods.EmptyStringDetector(login,passwd)))
        {
            User currentUser = DBWorker.InitUser(new User(login,passwd));
            if (currentUser.getCorrectness())
            {
                mySession.setAttribute("username", login);
                mySession.setAttribute("passwd", passwd);
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
    }

}
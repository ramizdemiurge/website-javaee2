package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by adsf on 15.01.2017.
 */
public class ExitServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        HttpSession mySession = req.getSession();
        mySession.removeAttribute("username");
        mySession.removeAttribute("password");
        resp.sendRedirect("/");
    }
}

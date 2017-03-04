package Controllers;

import Models.Methods;
import Models.UserModel.User;
import Models.WebConstants;
import Models.dbclasses.DBWorker;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

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
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf8");

        WebConstants index_page = new WebConstants("Enter", "utf-8", "ru");
        out.print(index_page.getHtmlHead());

        out.print("<div>\n" +
                "   <div class=\"uk-background-muted uk-padding uk-panel\">\n");

        String login = req.getParameter("login").trim().toLowerCase();
        String passwd = req.getParameter("passwd");

        if (!(Methods.EmptyStringDetector(login,passwd)))
        {
            User currentUser = DBWorker.InitUser(new User(login,passwd));
            if (currentUser.getCorrectness())
            {
                HttpSession mySession = req.getSession();
                mySession.setAttribute("username", login);
                mySession.setAttribute("passwd", passwd);
                resp.sendRedirect("/home");

            } else
            {
                out.println("<div uk-alert>Correct your login/password.</div>");
                HttpSession mySession = req.getSession();
                mySession.removeAttribute("username");
                mySession.removeAttribute("password");

            }
        } else
        {
            out.print("<div uk-alert>Enter your login and password.</div>");
        }
        out.print("</div></div>");
        out.print(index_page.getFooter());
        out.close();
    }

}
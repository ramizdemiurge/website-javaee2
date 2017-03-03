package Controllers;

import Models.WebConstants;
import Models.dbclasses.DBWorker;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by adsf on 14.01.2017.
 */
public class HomeServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        PrintWriter out = resp.getWriter();
        HttpSession mySession = req.getSession();
        resp.setContentType("text/html;charset=utf-8");
        WebConstants home_page = new WebConstants("Feed","utf-8", "ru");
        out.print(home_page.getHtmlHead());
        out.print("<div>\n" +
                "   <div class=\"uk-background-muted uk-padding uk-panel\">\n");
        String username = (String) mySession.getAttribute("username");
        String passwd = (String) mySession.getAttribute("passwd");
        if (!(username.equals(null) || username.equals("") || passwd.equals(null) || passwd.equals("")))
        {

            DBWorker worker_ = new DBWorker();
            boolean status = false;
            // String query = "select * from users WHERE username=" + login;
            String query = "select * from users WHERE username=\"" + username + "\"";
            String[] datas = new String[3];
            try
            {
                Statement statements = worker_.getConnection().createStatement();
                ResultSet resultsSet = statements.executeQuery(query);
                while (resultsSet.next())
                {
                    String password = resultsSet.getString("password");
                    datas[0] = resultsSet.getString("reg_date");
                    datas[1] = resultsSet.getString("name");
                    if (passwd.equals(password)) status = true;
                }
            } catch (SQLException ed)
            {
                out.println(ed);
                ed.printStackTrace();
            }
            if (status)
            {
                mySession.setAttribute("Datas", datas);
                mySession.setAttribute("username", username);
                getServletContext().getRequestDispatcher("/View/home_get.jsp").forward(req, resp);
            } else
            {
                out.println("Correct your login/password.");
            }
        }
        out.print("</div></div>test");
        out.print(home_page.getFooter());
        out.close();
    }
}
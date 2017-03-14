package Controllers;

import Models.dbclasses.DBWorker;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Controller
@RequestMapping("/home")
public class HomeController
{
    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        HttpSession mySession = req.getSession();
        String username = (String) mySession.getAttribute("username");
        String passwd = (String) mySession.getAttribute("passwd");
        if (username != null && passwd != null)
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
                ed.printStackTrace();
            }
            if (status)
            {
                mySession.setAttribute("Datas", datas);
                mySession.setAttribute("username", username);
                return "home_get";
            } else
            {
                req.getSession().setAttribute("messages","Correct your login/password.");
                resp.sendRedirect("/index.html");
            }
        }
        resp.sendRedirect("/index.html");
        return null;
    }
}

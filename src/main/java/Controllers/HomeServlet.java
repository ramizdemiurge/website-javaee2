package Controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by adsf on 14.01.2017.
 */
public class HomeServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
//        HttpSession mySession = req.getSession();
//        String username = (String) mySession.getAttribute("username");
//        String passwd = (String) mySession.getAttribute("passwd");
//        if (!(username.equals(null) || username.equals("") || passwd.equals(null) || passwd.equals("")))
//        {
//
//            DBWorker worker_ = new DBWorker();
//            boolean status = false;
//            // String query = "select * from users WHERE username=" + login;
//            String query = "select * from users WHERE username=\"" + username + "\"";
//            String[] datas = new String[3];
//            try
//            {
//                Statement statements = worker_.getConnection().createStatement();
//                ResultSet resultsSet = statements.executeQuery(query);
//                while (resultsSet.next())
//                {
//                    String password = resultsSet.getString("password");
//                    datas[0] = resultsSet.getString("reg_date");
//                    datas[1] = resultsSet.getString("name");
//                    if (passwd.equals(password)) status = true;
//                }
//            } catch (SQLException ed)
//            {
//                ed.printStackTrace();
//            }
//            if (status)
//            {
//                mySession.setAttribute("Datas", datas);
//                mySession.setAttribute("username", username);
//                getServletContext().getRequestDispatcher("/View/home_get.jsp").forward(req, resp);
//            } else
//            {
//                req.getSession().setAttribute("messages","Correct your login/password.");
//                resp.sendRedirect("/index.html");
//            }
//        }
    }
}
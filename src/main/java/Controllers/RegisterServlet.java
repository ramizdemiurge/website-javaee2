package Controllers;

import Models.dbclasses.DBWorker;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 * Created by adsf on 15.01.2017.
 */

public class RegisterServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

        String[] string_datas = new String[4];
        string_datas[0] = req.getParameter("login").trim().toLowerCase();
        string_datas[1] = req.getParameter("email").trim().toLowerCase();
        string_datas[2] = req.getParameter("passwd");
        string_datas[3] = req.getParameter("passwd2");
        if (!(string_datas[0].equals(null) || string_datas[0].equals("")))
        {
            if (!(string_datas[1].equals(null) || string_datas[1].equals("")))
            {
                if (!(string_datas[2].equals(null) || string_datas[2].equals("")))
                {
                    if (!(string_datas[3].equals(null) || string_datas[3].equals("")))
                    {
                        if (string_datas[2].equals(string_datas[3]))
                        {
                            /**
                             * Тут надо чекнуть, если ли в бд юзер с таким именем.
                             * Работаем с базой данных
                             */
                            DBWorker worker = new DBWorker();
                            boolean status = true;
                            // String query = "select * from users WHERE username=" + login;
                            String query = "select * from users WHERE username=\""+string_datas[0]+"\"";
                            try
                            {
                                Statement state = worker.getConnection().createStatement();
                                ResultSet resultSet = state.executeQuery(query);
                                while (resultSet.next())
                                {
                                    String bd_username = resultSet.getString("username");
                                    if (string_datas[0].equals(bd_username)) status = false;
                                }
                            } catch (SQLException err0) { System.err.print("DB connection error.<br>"+err0); }
                            if (status)
                            {
                                /**
                                 * Теперь чекаю, есть ли в бд юзер с таким e-mail
                                 * база данных
                                 */
                                query = "select * from users WHERE email=\""+string_datas[1]+"\"";
                                try
                                {
                                    Statement state = worker.getConnection().createStatement();
                                    ResultSet resultSet = state.executeQuery(query);
                                    while (resultSet.next())
                                    {
                                        String bd_email = resultSet.getString("email");
                                        if (string_datas[1].equals(bd_email)) status = false;
                                    }
                                } catch (SQLException err1) { System.err.print("DB connection error.[2]<br>"+err1); }

                                if (status)
                                {
                                    /**
                                     * Итак, все поля введены. Пароль и подтверждение совпадают.
                                     * В базе нет пользователей с совпадающим username и email.
                                     * Пожалуй, можно занести данные в бд. Следовало бы символы проверить.
                                     * Но это в будущем.
                                     */
                                    Date date = new Date();
                                    query = "INSERT INTO users (username,password,email,reg_date) VALUES (\""+string_datas[0]+"\",\""+string_datas[2]+"\",\""+string_datas[1]+"\",\""+date.toString()+"\")";
                                    try
                                    {
                                        Statement state = worker.getConnection().createStatement();
                                        state.executeUpdate(query);
                                        req.getSession().setAttribute("messages","You have registered.<br>Your username: "+string_datas[0]);
                                        resp.sendRedirect("/index.html");
                                    } catch (SQLException err) { System.err.print(err); }

                                } else {
                                    req.getSession().setAttribute("messages","Try another email adress.");
                                    resp.sendRedirect("/index.html");
                                }
                            } else {
                                req.getSession().setAttribute("messages","Try another username.");
                                resp.sendRedirect("/index.html");
                            }
                        } else {
                            req.getSession().setAttribute("messages","Password and password confirmation values are not same.");
                            resp.sendRedirect("/index.html");
                        }
                    } else {
                        req.getSession().setAttribute("messages","Enter your password confirmation.");
                        resp.sendRedirect("/index.html");
                    }
                } else {
                    req.getSession().setAttribute("messages","Enter your password.");
                    resp.sendRedirect("/index.html");
                }

            } else {
                req.getSession().setAttribute("messages","Enter your email.");
                resp.sendRedirect("/index.html");
            }
        } else {
            req.getSession().setAttribute("messages","Enter your login.");
            resp.sendRedirect("/index.html");
        }
    }
}
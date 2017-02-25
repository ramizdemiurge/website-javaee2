package servlets;

import constants.WebConstants;
import dbclasses.DBWorker;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf8");

        WebConstants register_page = new WebConstants("Register", "utf-8", "ru");
        out.print(register_page.getHtmlHead());
        out.print("<div>\n" +
                "   <div class=\"uk-background-muted uk-padding uk-panel\">\n");
        out.print("<div uk-alert>");

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
                            } catch (SQLException err0) { out.print("DB connection error.<br>"+err0); }
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
                                } catch (SQLException err1) { out.print("DB connection error.[2]<br>"+err1); }

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
                                        out.println("You have registered.");
                                        out.println("Your username: "+string_datas[0]);
                                    } catch (SQLException err) { out.print("DB connection error.[3]<br>"+err); }

                                } else {
                                    out.print("Try another email adress.");
                                }
                            } else {
                                out.print("Try another username.");
                            }
                        } else {
                            out.print("Password and password confirmation values are not same.");
                        }
                    } else {
                        out.print("Enter your password confirmation.");
                    }
                } else {
                    out.print("Enter your password.");
                }

            } else {
                out.print("Enter your email.");
            }
        } else {
            out.print("Enter your login.");
        }
        out.print("</div>");
        out.print("</div></div>");
        out.print(register_page.getFooter());
        out.close();

    }

    public static void main(String[] args)
    {
        DBWorker worker = new DBWorker();
        boolean status = true;
        String login = "ramiz";
        // String query = "select * from users WHERE username=" + login;
        String query = "select * from users WHERE username=\""+login+"\"";
        try
        {
            Statement state = worker.getConnection().createStatement();
            ResultSet resultSet = state.executeQuery(query);
            while (resultSet.next())
            {
                String bd_username = resultSet.getString("username");
                if (login.equals(bd_username)) status = false;
            }
        } catch (SQLException ignored) { System.out.print("DB connection error.1"); }
        System.out.println(status);
    }
}

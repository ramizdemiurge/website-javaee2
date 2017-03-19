package Controllers;

import config.DataConfig;
import entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping("/reg")
public class RegisterController
{
    @RequestMapping(method = RequestMethod.POST)
    public void RegistererContr(HttpServletRequest req, HttpServletResponse resp) throws IOException
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
                            ApplicationContext context = new AnnotationConfigApplicationContext(DataConfig.class);
                            UserService userService = context.getBean(UserService.class);
                            User user = userService.getByUsername(string_datas[0]);
                            if (user == null)
                            {
                                /**
                                 * Теперь чекаю, есть ли в бд юзер с таким e-mail
                                 * база данных
                                 */
                                user = userService.getByEmail(string_datas[1]);
                                if (user == null)
                                {
                                    /**
                                     * Итак, все поля введены. Пароль и подтверждение совпадают.
                                     * В базе нет пользователей с совпадающим username и email.
                                     * Пожалуй, можно занести данные в бд. Следовало бы символы проверить.
                                     * Но это в будущем.
                                     */
                                    Date date = new Date();
                                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                                        User user1 = new User();
                                        user1.setUsername(string_datas[0]);
                                        user1.setEmail(string_datas[1]);
                                        user1.setPassword(string_datas[2]);
                                        user1.setRegDate(sqlDate);
                                        user1.setReg_date(date.toString());
                                        userService.addUser(user1);

                                        req.getSession().setAttribute("messages","You have registered.<br>Your username: "+string_datas[0]);
                                        resp.sendRedirect("/index.html");

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

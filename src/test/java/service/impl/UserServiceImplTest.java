package service.impl;

import config.DataConfig;
import entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.UserService;

import java.util.Date;

/**
 * Created by allard on 3/19/17.
 */
public class UserServiceImplTest
{
    ApplicationContext context = new AnnotationConfigApplicationContext(DataConfig.class);
    UserService userService = context.getBean(UserService.class);
    @Test
    public void addUser() throws Exception
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(DataConfig.class);
        UserService userService = context.getBean(UserService.class);

        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        String lamer = "lamer";

        User user1 = new User();
        user1.setUsername(lamer);
        user1.setEmail(lamer);
        user1.setPassword(lamer);
        user1.setRegDate(sqlDate);
        user1.setReg_date(date.toString());
        userService.addUser(user1);
    }

    @Test
    public void delete() throws Exception
    {

    }

    @Test
    public void getByUsername() throws Exception
    {
        User user = userService.getByUsername("pisos");
        System.out.println(user);
    }

    @Test
    public void editUser() throws Exception
    {

    }

    @Test
    public void getAll() throws Exception
    {

    }

}
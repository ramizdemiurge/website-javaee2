package service.impl;

import config.DataConfig;
import entity.User;
import entity.enums.UserRoleEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import service.UserService;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by allard on 3/19/17.
 */
public class UserDetailsServiceImplTest
{
    @Autowired

    @Test
    public void loadUserByUsername() throws Exception
    {

        ApplicationContext context = new AnnotationConfigApplicationContext(DataConfig.class);
        UserService userService = context.getBean(UserService.class);

        User user = userService.getByUsername("ramiz");
        Set<GrantedAuthority> roles = new HashSet();
        roles.add(new SimpleGrantedAuthority(UserRoleEnum.USER.name()));

        UserDetails userDetails =
                new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), roles);
        System.out.println(user);
        System.out.println(userDetails);

    }

}
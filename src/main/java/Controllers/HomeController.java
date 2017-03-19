package Controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/home")
public class HomeController
{
    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException
    {
//        if (authentication != null)
//        {
//            CustomUserDetail myUserDetails = (CustomUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//            User user = myUserDetails.getUser(); //Fetch the custom property in User class
//            req.getSession().setAttribute("user",user);
//        }
        return "home_get";
    }

}

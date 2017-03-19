package Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/exit")
public class ExitController
{
    @RequestMapping(method = RequestMethod.GET)
    public void RemoveSession(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        HttpSession mySession = req.getSession();
        mySession.removeAttribute("user");
        resp.sendRedirect("/");
        //return null;
    }
}

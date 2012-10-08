package edu.sun.app.springcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * User: sunqipeng
 * Date: 12-9-6
 */
@Controller

public class LoginController {

    @RequestMapping("/login")
    public String login(HttpServletRequest request) {

        request.getParameter("username");
        System.out.println("this is the function invoke");
        return "/index";
    }

}

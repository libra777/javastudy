package edu.sun.app.springcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: sunqipeng
 * Date: 12-9-6
 */
@Controller
@RequestMapping("/sp/*")
public class SpringController {

    @RequestMapping("index")
    public String index() {
        System.out.println("this is the function invoke");
        return "spring/index.jsp";
    }
}

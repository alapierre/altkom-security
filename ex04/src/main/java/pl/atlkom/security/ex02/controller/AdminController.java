package pl.atlkom.security.ex02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.atlkom.security.ex02.service.UserService;

/**
 * Created by Administrator on 2016-06-21.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping("/adminSite")
    public ModelAndView adminSite() {


        System.out.println("adminSite()");

        userService.changeUserPassword("admin", "1234");

        return new ModelAndView("admin-site");
    }
}

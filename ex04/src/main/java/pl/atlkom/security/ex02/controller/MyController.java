/*
 * Copyright 2011-08-31 the original author or authors.
 */
package pl.atlkom.security.ex02.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.atlkom.security.ex02.service.UserService;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@Controller
public class MyController {

    @Autowired
    private UserService userService;

    protected Logger logger = Logger.getLogger(getClass());

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/")
    public ModelAndView home() {
        
        logger.debug("MyController.home()");

        ModelAndView model = new ModelAndView("home");

        model.addObject("name", "Ala");

        SecurityContext ctx = SecurityContextHolder.getContext();

        if(ctx != null) {
            Authentication auth = ctx.getAuthentication();

            logger.debug(auth.getPrincipal());

            User user = (User) auth.getPrincipal();

            logger.debug("logged user " + user.getUsername());

        } else {
            logger.debug("brak security kontext");
        }

        return model;
    }

    @RequestMapping("/changePass")
    public void changePass(@RequestParam String newPass) {

        userService.changeOwnPassword(newPass);

    }

}

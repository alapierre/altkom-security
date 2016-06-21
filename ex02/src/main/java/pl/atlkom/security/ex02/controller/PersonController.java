package pl.atlkom.security.ex02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.atlkom.model.Person;
import pl.atlkom.security.ex02.service.PersonService;

/**
 * Created by Administrator on 2016-06-21.
 */
@RequestMapping("/person")
@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/create")
    public ModelAndView create() {

        ModelAndView modelAndView = new ModelAndView("add-person");

        modelAndView.addObject("person", new Person());

        return modelAndView;

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Person person) {

        System.out.println(person);

        personService.save(person);

        return "person-list";
    }

}

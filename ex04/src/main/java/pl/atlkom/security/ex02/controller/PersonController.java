package pl.atlkom.security.ex02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.atlkom.security.ex02.model.Person;
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

    @RequestMapping("/edit")
    public ModelAndView edit(@RequestParam long id) {

        ModelAndView modelAndView = new ModelAndView("add-person");

        modelAndView.addObject("person", personService.load(id));

        return modelAndView;

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Person person) {

        //person.setName(HtmlUtils.htmlEscape(person.getName()));

        System.out.println(person);

        personService.save(person);

        return "redirect:/person/list";
    }

    @RequestMapping("/list")
    public ModelAndView list() {

        Iterable<Person> persons = personService.loadAll();

        ModelAndView model = new ModelAndView("person-list");
        model.addObject("persons", persons);

        return model;
    }

    @RequestMapping("/details")
    public ModelAndView details(@RequestParam long id) {

        Person p = personService.load(id);

        System.out.println(p);

        ModelAndView modelAndView = new ModelAndView("person-details");
        modelAndView.addObject("person", p);

        return modelAndView;
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam long id) {

        personService.delete(id);
        return "redirect:/person/list";
    }

}

/**
 * Copyright 2016-06-22 the original author or authors.
 */
package pl.atlkom.security.ex02.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.atlkom.security.ex02.model.Person;
import pl.atlkom.security.ex02.model.PersonDTO;
import pl.atlkom.security.ex02.service.PersonService;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */
@RestController
@RequestMapping("/rest/person")
public class MyRestController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public PersonDTO load(@PathVariable long id) {

        Person person = personService.load(id);

        ModelMapper mapper = new ModelMapper();

        return mapper.map(person, PersonDTO.class);

    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody PersonDTO p) {

        System.out.println(p);

        ModelMapper mapper = new ModelMapper();

        personService.save(mapper.map(p, Person.class));

    }

}

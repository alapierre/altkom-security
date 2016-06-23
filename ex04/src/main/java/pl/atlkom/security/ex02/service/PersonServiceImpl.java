package pl.atlkom.security.ex02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import pl.atlkom.security.ex02.model.GiodoLog;
import pl.atlkom.security.ex02.model.GiodoLogOperationType;
import pl.atlkom.security.ex02.model.Person;
import pl.atlkom.security.ex02.repository.GiodoLogRepository;
import pl.atlkom.security.ex02.repository.PersonDAO;

import java.util.Date;

/**
 * Created by Administrator on 2016-06-21.
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDAO personDAO;

    @Autowired
    private GiodoLogService giodoLogService;

    @Secured({"ROLE_MANAGER", "ROLE_ADMIN"})
    public void save(Person person) {

        GiodoLogOperationType operationType = person.getId() == 0
                ? GiodoLogOperationType.CREATE
                : GiodoLogOperationType.EDIT;

        personDAO.saveAndFlush(person);

        giodoLogService.log(person, operationType);

    }

    public Person load(long id) {
        return personDAO.findOne(id);
    }

    public Iterable<Person> loadAll() {
        return personDAO.findAll();
    }

    @Secured("ROLE_ADMIN")
    public void delete(long id) {

        personDAO.delete(id);
        giodoLogService.log(Person.class.toString(), id, GiodoLogOperationType.DELETE);


    }
}

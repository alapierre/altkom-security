package pl.atlkom.security.ex02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.atlkom.model.Person;
import pl.atlkom.security.ex02.repository.PersonDAO;

/**
 * Created by Administrator on 2016-06-21.
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDAO personDAO;

    public void save(Person person) {
        personDAO.save(person);
    }

    public Person load(long id) {
        return personDAO.findOne(id);
    }

    public Iterable<Person> loadAll() {
        return personDAO.findAll();
    }

    public void delete(long id) {
        personDAO.delete(id);
    }
}

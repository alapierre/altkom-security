package pl.atlkom.security.ex02.service;

import pl.atlkom.model.Person;

/**
 * Created by Administrator on 2016-06-21.
 */
public interface PersonService {
    void save(Person person);

    Person load(long id);

    Iterable<Person> loadAll();

    void delete(long id);
}

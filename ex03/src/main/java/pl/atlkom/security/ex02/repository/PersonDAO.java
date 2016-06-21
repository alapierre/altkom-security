/**
 * Copyright 2016-06-21 the original author or authors.
 */
package pl.atlkom.security.ex02.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.atlkom.security.ex02.model.Person;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */
@Repository
public interface PersonDAO extends CrudRepository<Person, Long> {
}

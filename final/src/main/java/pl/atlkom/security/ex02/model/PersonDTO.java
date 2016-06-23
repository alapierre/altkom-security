/**
 * Copyright 2016-06-22 the original author or authors.
 */
package pl.atlkom.security.ex02.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */
public class PersonDTO {

    private long id;

    @Size(min = 0, max = 32)
    private String name;

    @Min(1)
    @Max(199)
    private int age;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}

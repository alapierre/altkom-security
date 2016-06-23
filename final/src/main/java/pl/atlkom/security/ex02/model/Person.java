/**
 * Copyright 2016-06-21 the original author or authors.
 */
package pl.atlkom.security.ex02.model;


import org.hibernate.envers.Audited;

import javax.persistence.Entity;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */

@Entity
@Audited
public class Person extends BaseEntity {

    private String name;

    private int age;

    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public long getId() {
        return super.getId();
    }

    public void setId(long id) {
        super.setId(id);
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
        return "Person{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

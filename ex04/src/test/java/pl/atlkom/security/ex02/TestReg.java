/**
 * Copyright 2016-06-22 the original author or authors.
 */
package pl.atlkom.security.ex02;

import org.junit.Test;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */
public class TestReg {

    @Test
    public void test() {

        System.out.println(!"/rest/person/".matches( "/rest/.+"));

    }
}

package com.karma.practice.reflection.objectrelationalmapper;

import com.karma.practice.reflection.model.Person;
import com.karma.practice.reflection.orm.EntityManager;

import java.sql.SQLException;

public class WritingObjects {
    public static void main(String[] args) throws SQLException, IllegalAccessException {
        EntityManager<Person> em  =  EntityManager.of(Person.class);

        Person linda = new Person("linda",22);
        Person jhon = new Person("jhon",23);
        Person kungs = new Person("kungs",28);
        Person lee = new Person("lee",35);

        System.out.println(linda);
        System.out.println(jhon);
        System.out.println(kungs);
        System.out.println(lee);

        System.out.println("Writing objects into db");
        em.persist(linda);
        em.persist(jhon);
        em.persist(kungs);
        em.persist(lee);

        System.out.println(linda);
        System.out.println(jhon);
        System.out.println(kungs);
        System.out.println(lee);

    }
}

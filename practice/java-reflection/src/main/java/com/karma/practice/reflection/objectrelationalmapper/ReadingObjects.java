package com.karma.practice.reflection.objectrelationalmapper;

import com.karma.practice.reflection.model.Person;
import com.karma.practice.reflection.orm.EntityManager;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class ReadingObjects {
    public static void main(String[] args) throws SQLException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        EntityManager<Person> entityManager = EntityManager.of(Person.class);

        Person linda = entityManager.find(Person.class, 1L);
        Person jhon = entityManager.find(Person.class, 2L);
        Person kungs = entityManager.find(Person.class, 3L);
        Person lee = entityManager.find(Person.class, 4L);

        System.out.println(linda);
        System.out.println(jhon);
        System.out.println(kungs);
        System.out.println(lee);
    }
}

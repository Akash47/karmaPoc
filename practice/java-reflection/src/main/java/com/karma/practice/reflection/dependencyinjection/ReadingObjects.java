package com.karma.practice.reflection.dependencyinjection;



import com.karma.practice.reflection.dependencyinjection.beanmanager.BeanManager;
import com.karma.practice.reflection.dependencyinjection.orm.EntityManager;
import com.karma.practice.reflection.dependencyinjection.orm.ManagedEntityManager;
import com.karma.practice.reflection.model.Person;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class ReadingObjects {
    public static void main(String[] args) throws SQLException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        BeanManager beanManager = BeanManager.getInstance();
        EntityManager<Person> entityManager = beanManager.getInstance(ManagedEntityManager.class);

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

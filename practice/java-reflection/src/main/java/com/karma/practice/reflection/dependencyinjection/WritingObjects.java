package com.karma.practice.reflection.dependencyinjection;


import com.karma.practice.reflection.dependencyinjection.beanmanager.BeanManager;
import com.karma.practice.reflection.dependencyinjection.orm.EntityManager;
import com.karma.practice.reflection.dependencyinjection.orm.ManagedEntityManager;
import com.karma.practice.reflection.model.Person;

public class WritingObjects {

    BeanManager beanManager = BeanManager.getInstance();
    EntityManager<Person> entityManager = beanManager.getInstance(ManagedEntityManager.class);

    Person linda = new Person("linda",22);
    Person jhon = new Person("jhon",23);
    Person kungs = new Person("kungs",28);
    Person lee = new Person("lee",35);


//        System.out.println(linda);
//        System.out.println(jhon);
//        System.out.println(kungs);
//        System.out.println(lee);

//        System.out.println("Writing objects into db");
//        entityManager.persist(linda);
//        entityManager.persist(jhon);
//        entityManager.persist(kungs);
//        entityManager.persist(lee);
//
//        System.out.println(linda);
//        System.out.println(jhon);
//        System.out.println(kungs);
//        System.out.println(lee);

}

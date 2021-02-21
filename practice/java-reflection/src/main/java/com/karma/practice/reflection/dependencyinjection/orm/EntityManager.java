package com.karma.practice.reflection.dependencyinjection.orm;


import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public interface EntityManager<T> {

    void persist(T t) throws SQLException, IllegalAccessException;

    T find(Class<T> clss, Object primaryKey) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
}

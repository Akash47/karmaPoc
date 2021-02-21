package com.karma.practice.reflection.orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2EntityManager<T> extends AbstractEntityManager<T> {

    @Override
    public Connection buildConnection() throws SQLException {
        Connection connection = DriverManager.
                getConnection("jdbc:h2:C:\\project\\POC\\karmaPoc\\practice\\java-reflection\\db-files\\karmaPoc"
                        , "sa", "");
        return connection;

    }
}

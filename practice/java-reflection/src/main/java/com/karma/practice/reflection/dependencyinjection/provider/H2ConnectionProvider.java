package com.karma.practice.reflection.dependencyinjection.provider;

import com.karma.practice.reflection.annotations.Provides;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2ConnectionProvider {
    @Provides
    public Connection buildConnection() throws SQLException {
        Connection connection = DriverManager.
                getConnection("jdbc:h2:C:\\project\\POC\\karmaPoc\\practice\\java-reflection\\db-files\\karmaPoc"
                        , "sa", "");
        return connection;

    }
}

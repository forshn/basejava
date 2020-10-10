package com.urise.webapp.sql;

import com.urise.webapp.exception.StorageException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SqlHelper {
    //использовать паттерн Стратегия, используя лямбды
    //Вынести общий код (getConnection(), prepareStatement, catch SQLException)
    // в класс SqlHelper (https://dzone.com/articles/removing-duplicate-code-with-lambda-expressions)

    public final ConnectionFactory connectionFactory;

    public SqlHelper(String dbUrl, String dbUser, String dbPassword) {
        connectionFactory = () -> DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }

    private <T> void makeExecution(String query, SqlExecutor<T> executor) {
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            executor.accept(ps);
        } catch (SQLException e) {
            throw new StorageException(e);
        }
    }

    @FunctionalInterface
    public interface SqlExecutor<T> {
        void accept(PreparedStatement ps) throws SQLException;
    }
}

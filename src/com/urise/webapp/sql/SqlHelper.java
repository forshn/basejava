package com.urise.webapp.sql;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.StorageException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SqlHelper {
    public final ConnectionFactory connectionFactory;
    private static final String POSTEGRESQL_DUPLICATE_PK = "505050";

    public SqlHelper(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public <T> T makeExecution(String query, SqlExecutor<T> executor) {
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            return executor.execute(ps);
        } catch (SQLException e) {
            if (e.getSQLState().equals(POSTEGRESQL_DUPLICATE_PK)) {
                throw new ExistStorageException(e);
            } else {
                throw new StorageException(e);
            }
        }
    }

    @FunctionalInterface
    public interface SqlExecutor<T> {
        T execute(PreparedStatement ps) throws SQLException;
    }
}

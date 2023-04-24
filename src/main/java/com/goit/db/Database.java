package com.goit.db;

import com.goit.exception.DbException;
import org.h2.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String H2_URL = "jdbc:h2:mem:local";
    private static final String USER = "admin";
    private static final String PASSWORD = "12345";
    private static Database instance;
    private Connection connection;
    private Database() {
        try {
            connection = DriverManager.getConnection(H2_URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new DbException("Instantiation of database failed", e);
        }
    }

    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}

package com.goit.service;

import com.goit.db.Database;
import com.goit.exception.DbException;
import com.goit.reader.Reader;
import com.goit.service.datasource.DatabasePopulateDatasource;

import java.sql.Connection;
import java.sql.Statement;

public class DatabasePopulateService {
    private static final String MYH2_URL = "jdbc:h2:~/test";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "12345";

    public static void main(String[] args) {
        DatabasePopulateDatasource data = DatabasePopulateDatasource.of(MYH2_URL, USERNAME, PASSWORD);
        Reader sb = new Reader("sql/populate_db.sql");
        Connection conn = Database.getInstance().getConnection();
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(sb.read());
            stmt.close();
            conn.close();
        } catch (Exception e) {
            throw new DbException("Connection or statement failed",e);
        }
    }
}

package com.goit.service;

import com.goit.db.Database;
import com.goit.exception.DbException;
import com.goit.reader.Reader;

import java.sql.Connection;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void main(String[] args) {
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

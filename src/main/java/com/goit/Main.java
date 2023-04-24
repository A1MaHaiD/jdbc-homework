package com.goit;

import com.goit.db.Database;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection conn = Database.getInstance().getConnection();
    }
}
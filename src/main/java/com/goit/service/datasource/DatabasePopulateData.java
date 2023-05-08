package com.goit.service.datasource;

import com.goit.query.tables.Worker;
import com.goit.service.DatabaseQueryService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DatabasePopulateData {
    DatabaseQueryService databasePopulateService = new DatabaseQueryService();
    PreparedStatement preparedStatement;
    Connection connection;

    public void insertToTableWorkerDate() throws SQLException {
        List<Worker> workers = databasePopulateService.getWorkersDataFromFile();
        preparedStatement = connection.prepareStatement("INSERT INTO worker (name, birthday, level, salary) VALUES (?,?,?,?)");
        for (Worker worker: workers) {
            preparedStatement.setString(1, worker.getName());
            preparedStatement.setDate(2,worker.getBirthday());
            preparedStatement.setString(3, worker.getLevel());
            preparedStatement.setInt(4,worker.getSalary());
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
    }
}
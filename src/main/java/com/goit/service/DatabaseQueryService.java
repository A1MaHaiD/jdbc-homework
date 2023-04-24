package com.goit.service;

import com.goit.db.Database;
import com.goit.exception.DbException;
import com.goit.query.LongestProject;
import com.goit.query.MaxProjectCountClient;
import com.goit.query.MaxSalaryWorker;
import com.goit.query.YoungestEldestWorkers;
import com.goit.reader.Reader;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public class DatabaseQueryService {
    public static void main(String[] args) {
        List<MaxProjectCountClient> maxProjectCountClients = new DatabaseQueryService().findMaxProjectsClient();
        List<MaxSalaryWorker> maxSalaryWorker = new DatabaseQueryService().findMaxSalaryWorker();
        List<YoungestEldestWorkers> youngestEldestWorkers = new DatabaseQueryService().findYoungestEldestWorkers();
        List<LongestProject> longestProject = new DatabaseQueryService().findLongestProject();
    }
    private static List<LongestProject> findLongestProject() {
        Reader sb = new Reader("sql/find_longest_project.sql");
        Connection conn = Database.getInstance().getConnection();
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(sb.read());
            stmt.close();
            conn.close();
            return null;
            // Я не зрозумів як зробити домашнє завдання.
            // Бо пів лекції акцентувалось зовсім на інше. Ніби зятагування відео.
        } catch (Exception e) {
            throw new DbException("Connection or statement failed",e);
        }
    }

    private static List<YoungestEldestWorkers> findYoungestEldestWorkers() {
        Reader sb = new Reader("sql/find_youngest_eldest_workers.sql");
        Connection conn = Database.getInstance().getConnection();
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(sb.read());
            stmt.close();
            conn.close();
            return null;
            // Я не зрозумів як зробити домашнє завдання.
            // Бо пів лекції акцентувалось зовсім на інше. Ніби зятагування відео.
        } catch (Exception e) {
            throw new DbException("Connection or statement failed",e);
        }
    }

    private static List<MaxSalaryWorker> findMaxSalaryWorker() {
        Reader sb = new Reader("sql/find_maxSalaryWorker.sql");
        Connection conn = Database.getInstance().getConnection();
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(sb.read());
            stmt.close();
            conn.close();
            return null;
            // Я не зрозумів як зробити домашнє завдання.
            // Бо пів лекції акцентувалось зовсім на інше. Ніби зятагування відео.
        } catch (Exception e) {
            throw new DbException("Connection or statement failed",e);
        }
    }

    private static List<MaxProjectCountClient> findMaxProjectsClient() {

        Reader sb = new Reader("sql/find_max_projects_client.sql");
        Connection conn = Database.getInstance().getConnection();
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(sb.read());
            stmt.close();
            conn.close();
            return null;
            // Я не зрозумів як зробити домашнє завдання.
            // Бо пів лекції акцентувалось зовсім на інше. Ніби зятагування відео.
        } catch (Exception e) {
            throw new DbException("Connection or statement failed",e);
        }
    }
}

package com.goit.service;

import com.goit.db.Database;
import com.goit.exception.DbException;
import com.goit.query.LongestProject;
import com.goit.query.MaxProjectCountClient;
import com.goit.query.MaxSalaryWorker;
import com.goit.query.YoungestEldestWorkers;
import com.goit.reader.Reader;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    public static void main(String[] args) {
        DatabaseQueryService service = new DatabaseQueryService();
        printList(service.findMaxProjectsClient());
        printList(service.findMaxSalaryWorker());
        printList(service.findLongestProject());
        printList(service.findYoungestEldestWorkers());
    }

    private static void printList(List list){
        System.out.println(list);
    }

    private List<LongestProject> findLongestProject() {
        Reader sb = new Reader("sql/find_longest_project.sql");
        List<LongestProject> list = new ArrayList<>();
        try (Connection conn = Database.getInstance().getConnection(); Statement stmt = conn.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(sb.read());
            while (resultSet.next()) {
                list.add(new LongestProject(resultSet.getInt(1), resultSet.getLong(2)));
            }
            return list;
        } catch (Exception e) {
            throw new DbException("Connection or statement failed", e);
        }
    }

    private List<YoungestEldestWorkers> findYoungestEldestWorkers() {
        Reader sb = new Reader("sql/find_youngest_eldest_workers.sql");
        List<YoungestEldestWorkers> list = new ArrayList<>();
        try (Connection conn = Database.getInstance().getConnection();
             Statement stmt = conn.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(sb.read());
            while (resultSet.next()) {
                list.add(new YoungestEldestWorkers(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getDate(3)));
            }
            return list;
        } catch (Exception e) {
            throw new DbException("Connection or statement failed", e);
        }
    }

    private List<MaxSalaryWorker> findMaxSalaryWorker() {
        Reader sb = new Reader("sql/find_max_salary_worker.sql");
        List<MaxSalaryWorker> list = new ArrayList<>();
        try (Connection conn = Database.getInstance().getConnection();
             Statement stmt = conn.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(sb.read());
            while (resultSet.next()) {
                list.add(new MaxSalaryWorker(
                        resultSet.getString(1),
                        resultSet.getInt(2)));
            }
            return list;
        } catch (Exception e) {
            throw new DbException("Connection or statement failed", e);
        }
    }

    private List<MaxProjectCountClient> findMaxProjectsClient() {
        Reader sb = new Reader("sql/find_max_projects_client.sql");
        List<MaxProjectCountClient> list = new ArrayList<>();
        try (Connection conn = Database.getInstance().getConnection();
             Statement stmt = conn.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(sb.read());
            while (resultSet.next()) {
                list.add(new MaxProjectCountClient(
                        resultSet.getString(1),
                        resultSet.getInt(2)));
            }
            return list;
        } catch (Exception e) {
            throw new DbException("Connection or statement failed", e);
        }
    }
}

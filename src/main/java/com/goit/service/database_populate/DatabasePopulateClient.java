package com.goit.service.database_populate;

import com.goit.db.Database;
import com.goit.query.tables.Client;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DatabasePopulateClient {
    PreparedStatement preparedStatement;
    Connection connection;

    public void clientInsert() {
        List<Client> clientList = addClientInfo();
        try {
            connection = Database.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO client (id, name) VALUES (?, ?)"
            );
            for (Client client : clientList) {
                preparedStatement.setInt(1,client.getId());
                preparedStatement.setString(2,client.getName());
            }
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Client> addClientInfo() {
        List<Client> clientList = new ArrayList<>();
        String line = readFile("client.txt");
        Scanner sc = new Scanner(line);
        while (sc.hasNextLine()) {
            String[] query = sc.nextLine().split(",");
            Client client = new Client();
            client.setId(Integer.parseInt(query[0]));
            client.setName(query[1]);
            clientList.add(client);
        }
        return clientList;
    }

    public String readFile(String file) {
        String fileValue = null;
        try {
            fileValue = Files.readString(Path.of(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileValue;
    }
}

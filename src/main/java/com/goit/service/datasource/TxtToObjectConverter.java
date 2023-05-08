package com.goit.service.datasource;

import com.goit.query.tables.Worker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TxtToObjectConverter {

    public static List<String> readTxtFile(String fileName) throws IOException {
        List<String> lines = new ArrayList<>();
        ClassLoader classLoader = TxtToObjectConverter.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        return lines;
    }

    public static void main(String[] args) throws IOException {
        List<String> lines = readTxtFile("resources/worker.txt");
    }
}
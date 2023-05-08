package com.goit.service.datasource;

import java.io.*;
import java.util.Properties;

public class ReadFileFromResources {
    public static void main(String[] args) {
        Properties properties = new Properties();
        String fileName = "config.properties";
        InputStream inputStream = ReadFileFromResources.class.getClassLoader().getResourceAsStream(fileName);
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileReader readWorkerFile(File file) throws FileNotFoundException {
        String uri = "resources/txt/worker.txt";
        FileReader fileReader = new FileReader(file);
        return fileReader;
    }
}
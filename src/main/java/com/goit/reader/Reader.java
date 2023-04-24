package com.goit.reader;

import com.goit.exception.ReadException;

import java.io.InputStream;
import java.util.Scanner;

public class Reader {
    private final String resourceName;

    public Reader(String resourceName) {
        this.resourceName = resourceName;
    }

    public String read() {
        try (InputStream stream = Reader.class.getClassLoader().getResourceAsStream(resourceName)) {
            assert stream != null;
            Scanner scanner = new Scanner(stream);
            StringBuilder builder = new StringBuilder();
            while (scanner.hasNextLine()) {
                builder.append(scanner.nextLine());
                builder.append("\n");
            }
            return builder.toString();
        } catch (Exception e) {
            throw new ReadException("Resource: " + resourceName + " reading failed", e);
        }
    }
}

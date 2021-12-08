package ua.foxminded.task6.allReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reader {
    public List readFile(String path) throws IOException {
        InputStream in = getClass().getResourceAsStream(path); 
        List<String> fileLines = new LinkedList<>();
        try (BufferedReader streamFromFiles = new BufferedReader(new InputStreamReader(in))) {
            fileLines = streamFromFiles.lines().sorted().collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalArgumentException("file missing " + path);

        }
        return fileLines;
    }

}

package com.windmill312.orchestrator.utils;

import org.springframework.stereotype.Component;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class FileUtils {
    public String readOutputFile(String fileName) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(new BufferedInputStream(new FileInputStream(fileName)));
        BufferedReader br = new BufferedReader(inputStreamReader);
        StringBuilder resultBuilder = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            resultBuilder.append(line).append("\n");
        }
        return resultBuilder.toString();
    }
}

package com.example.navalbattle.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileCRUD {

    private final String filePath;
    public FileCRUD(String filePath){
        this.filePath = filePath;
    }

    public void create(String content){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true))) {
            bufferedWriter.write(content);
            bufferedWriter.newLine();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public List<String> read() {

        List<String> lines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public void update(int lineNumber, String newContent) {
        List<String> lines = read();

        if (lineNumber >= 0 && lineNumber < lines.size()) {
            lines.set(lineNumber, newContent);
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
                for (String line : lines) {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid line number.");
        }
    }

    public void delete(int lineNumber) {
        List<String> lines = read();
        if (lineNumber >= 0 && lineNumber < lines.size()) {
            lines.remove(lineNumber);
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
                for (String line : lines) {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid line number.");
        }
    }


}

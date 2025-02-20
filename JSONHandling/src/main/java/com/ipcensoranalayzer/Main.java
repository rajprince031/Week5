package com.ipcensoranalayzer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        try {
            // Read and sanitize data from JSON
            List<Map<String, Object>> jsonData = readJsonData("ipl_matches.json");
            List<Map<String, Object>> sanitizedJsonData = sanitizeJsonData(jsonData);
            writeJsonData(sanitizedJsonData, "sanitized_ipl_matches.json");

            // Read and sanitize data from CSV
            List<String[]> csvData = readCsvData("ipl_matches.csv");
            List<String[]> sanitizedCsvData = sanitizeCsvData(csvData);
            writeCsvData(sanitizedCsvData, "sanitized_ipl_matches.csv");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to read data from JSON file
    public static List<Map<String, Object>> readJsonData(String fileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(fileName), List.class);
    }

    // Method to sanitize JSON data based on censorship rules
    public static List<Map<String, Object>> sanitizeJsonData(List<Map<String, Object>> data) {
        List<Map<String, Object>> sanitizedData = new ArrayList<>();

        for (Map<String, Object> match : data) {
            match.put("team1", "Team 1");
            match.put("team2", "Team 2");
            match.put("player_of_the_match", "Player X");
            match.put("score_team1", "Hidden");
            match.put("score_team2", "Hidden");
            sanitizedData.add(match);
        }

        return sanitizedData;
    }

    // Method to write sanitized JSON data to a new file
    public static void writeJsonData(List<Map<String, Object>> data, String fileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), data);
    }

    // Method to read data from CSV file
    public static List<String[]> readCsvData(String fileName) throws IOException, CsvException {
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            return reader.readAll();
        }
    }

    // Method to sanitize CSV data based on censorship rules
    public static List<String[]> sanitizeCsvData(List<String[]> data) {
        List<String[]> sanitizedData = new ArrayList<>();

        for (String[] row : data) {
            if (row[0].equals("match_id")) {  // Skip header row
                sanitizedData.add(row);
                continue;
            }
            row[1] = "Team 1";  // Anonymize team1
            row[2] = "Team 2";  // Anonymize team2
            row[3] = "Player X";  // Mask player of the match
            row[4] = "Hidden";  // Hide score of team1
            row[5] = "Hidden";  // Hide score of team2
            sanitizedData.add(row);
        }

        return sanitizedData;
    }

    // Method to write sanitized CSV data to a new file
    public static void writeCsvData(List<String[]> data, String fileName) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(fileName))) {
            writer.writeAll(data);
        }
    }
}

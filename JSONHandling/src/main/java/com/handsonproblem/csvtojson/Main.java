package com.handsonproblem.csvtojson;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String csvFile = "src/main/java/com/handsonproblem/csvtojson/data.csv";  // Path to your CSV file

        try {
            // Initialize CSVReader to read the CSV file
            CSVReader csvReader = new CSVReader(new FileReader(csvFile));

            // Read the data from the CSV file
            List<String[]> records = csvReader.readAll();

            // Get the header from the CSV (first row)
            List<Map<String, String>> dataList = getMaps(records);

            // Initialize ObjectMapper to convert list to JSON
            ObjectMapper objectMapper = new ObjectMapper();

            // Convert list of maps to JSON string
            String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataList);

            // Output the JSON
            System.out.println("Converted JSON:\n" + jsonString);

        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

    private static List<Map<String, String>> getMaps(List<String[]> records) {
        String[] header = records.get(0);

        // Convert CSV rows into a list of maps (each row as a map of column name -> value)
        List<Map<String, String>> dataList = new java.util.ArrayList<>();

        for (int i = 1; i < records.size(); i++) {  // Skip the header row
            String[] row = records.get(i);
            Map<String, String> rowMap = new java.util.HashMap<>();

            for (int j = 0; j < header.length; j++) {
                rowMap.put(header[j], row[j]);
            }

            dataList.add(rowMap);
        }
        return dataList;
    }
}

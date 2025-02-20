package com.handsonproblem.jsontoxml;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Main {
    public static void main(String[] args) {
        try {
            // Sample JSON input
            String jsonString = "{\"name\": \"John\", \"age\": 30, \"city\": \"New York\"}";

            // Initialize Jackson ObjectMapper for JSON and XmlMapper for XML
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonString);

            XmlMapper xmlMapper = new XmlMapper();

            // Convert JSON to XML
            String xmlString = xmlMapper.writeValueAsString(jsonNode);

            // Output XML result
            System.out.println("Converted XML:\n" + xmlString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

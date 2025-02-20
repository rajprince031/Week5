package com.handsonproblem.readjsonfile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {

        File jsonFile = new File("src/main/resources/MOCK_DATA.json");
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode jsonArray = objectMapper.readTree(jsonFile);
        Iterator<JsonNode> elements = jsonArray.elements();

        while(elements.hasNext()){
            JsonNode element = elements.next();
            System.out.println(element);
            System.out.println();
        }


    }
}

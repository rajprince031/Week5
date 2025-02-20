package com.handsonproblem.filterdata;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.File;
import java.util.Iterator;

public class FilterRecord {
    public static void main(String[] args) {

        //Create Object of ObjectMapper class
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("/Users/princeraj/Desktop/Capgemini-Training/Week5/Day2/JSONHandling/src/main/resources/MOCK_DATA.json");
        ArrayNode filterArray = objectMapper.createArrayNode();
        try{
            JsonNode jsonArray = objectMapper.readTree(file);
            Iterator<JsonNode> elements = jsonArray.elements();
            while(elements.hasNext()){
                JsonNode user = elements.next();
                int age = user.get("age").asInt();
                if(age > 25){
                    filterArray.add(user);
                }
            }

            System.out.println(filterArray);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

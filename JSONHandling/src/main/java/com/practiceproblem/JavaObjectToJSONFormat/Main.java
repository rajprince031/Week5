package com.practiceproblem.JavaObjectToJSONFormat;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {
        try{
            // Create Object of ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            //Create Object of car class
            Car car = new Car("BMW","300F",2016);

            // Convert Java Object to JSON String
            String jsonString = objectMapper.writeValueAsString(car);

            JsonNode jsonData = objectMapper.readTree(jsonString);
            //Print the JSON
            System.out.println("Car JSON Data - "+jsonData);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

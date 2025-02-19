package com.practiceproblem.JavaObjectToJSONFormat;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {
        try{
            // Create a Object of ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            //Create a Object of car class
            Car car = new Car("BMW","300F",2016);

            // Convert Java Object to JSON String
            String carJSON = objectMapper.writeValueAsString(car);

            //Print the JSON
            System.out.println("Car - "+carJSON);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

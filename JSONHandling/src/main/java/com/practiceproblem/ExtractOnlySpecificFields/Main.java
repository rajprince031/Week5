package com.practiceproblem.ExtractOnlySpecificFields;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        //Create a Object of ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        //Create a Object of File
        File file = new File("/Users/princeraj/Desktop/Capgemini-Training/Week3/JSONHandling/src/main/java/com/practiceproblem/ExtractOnlySpecificFields/demo.json");

        try{
            //Create a Object of Employee Class
            Employee employee = objectMapper.readValue(file,Employee.class);

            //Print The Employee Details
            System.out.println("Name : " +employee.getName());
            System.out.println("Email : " +employee.getEmail());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

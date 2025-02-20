package com.practiceproblem.ExtractOnlySpecificFields;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        //Create Object of ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        //Create Object of File
        File file = new File("src/main/resources/demo1.json");

        ArrayList<Employee> employees = new ArrayList<>();

        try{
            JsonNode jsonArray = objectMapper.readTree(file);

            Iterator<JsonNode> elements = jsonArray.elements();

            while(elements.hasNext()){

                JsonNode oneNode = elements.next();

                //Create Object of Employee Class
                Employee employee = objectMapper.treeToValue(oneNode,Employee.class);

                employees.add(employee);
            }



            //Print The Employees Details
           for(Employee employee : employees){
               System.out.println("Name : " +employee.getName());
               System.out.println("Email : " +employee.getEmail());
           }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

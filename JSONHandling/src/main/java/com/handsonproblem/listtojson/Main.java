package com.handsonproblem.listtojson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practiceproblem.listtojson.User;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {

        //Create a ArrayList
        ArrayList<User> users = new ArrayList<>();

        //Add users to the list
        users.add(new User("Prince","raj@gmail.com"));
        users.add(new User("Viraj","viraj@gmail.com"));
        users.add(new User("Kancha","kanch@gmail.com"));

        //Create Object of the ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        //Convert List of user to string
        String stringUserArray = objectMapper.writeValueAsString(users);

        //String to JsonArray
        JsonNode jsonUserArray = objectMapper.readTree(stringUserArray);

        //Display the json user array
        System.out.println(jsonUserArray);
    }
}

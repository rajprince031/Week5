package com.practiceproblem.JoinTwoJSONObject;

import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {

        //Create a Object of JSONObject for object1
        JSONObject object1 = new JSONObject();
        object1.put("Name","Prince");
        object1.put("Age",22);

        //Create a Object of JSONObject for object2
        JSONObject object2 = new JSONObject();
        object2.put("Email","Prince");
        object2.put("Mobile No","9060500429");

        //Create a Object of JSONObject for combineObject
        JSONObject combineObject = new JSONObject();

        for(String key : object1.keySet()){
            combineObject.put(key, object1.get(key));
        }

        for(String key : object2.keySet()){
            combineObject.put(key, object2.get(key));
        }

        //Display the combineObject
        System.out.println(combineObject);
    }
}

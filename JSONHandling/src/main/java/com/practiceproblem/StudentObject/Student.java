//Using org.json Library

package com.practiceproblem.StudentObject;
import org.json.JSONArray;
import org.json.JSONObject;

public class Student {
    public static void main(String[] args) {

        // Create a JSONArray for subjects
        JSONArray subjects = new JSONArray();
        subjects.put("Maths");
        subjects.put("Biology");
        subjects.put("Chemistry");
        subjects.put("Physics");

        // Create a JSONObject for the student
        JSONObject student = new JSONObject();
        student.put("Name", "Prince Raj");
        student.put("Age", 22);
        student.put("Subjects",subjects);

        //Display the Student object
        System.out.println("Student JSON:- "+ student.toString());

    }
}

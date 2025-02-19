package com.practiceproblem.ExtractOnlySpecificFields;

public class Employee {
    public String name;
    public String email;

    Employee(){}

    public Employee(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString(){
        return "Name : "+ this.name +"\n"+"Email : "+this.email;
    }
}

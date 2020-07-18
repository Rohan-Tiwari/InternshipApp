package com.example.internshipapp;

public class Data {

    public String name;
    public String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Data(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Data(){}
}

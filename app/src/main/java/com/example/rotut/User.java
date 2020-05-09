package com.example.rotut;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.UUID;

public class User  {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String major;
    private String prefLoc;
    private String school;
    private String classYear;
    private UUID id;
    private ArrayList<String> rating;
    private ArrayList<String> classes;

    public User(String newFirstName, String newLastName, String newEmail, String newPassword,
                String newMajor, String newPrefLoc, String newSchool, String newClassYear,
                ArrayList<String> newClasses){
        this.firstName = newFirstName;
        this.lastName = newLastName;
        this.email = newEmail;
        this.password = newPassword;
        this.major = newMajor;
        this.prefLoc = newPrefLoc;
        this.school = newSchool;
        this.classYear = newClassYear;
        this.classes = (ArrayList<String>) newClasses.clone();
        this.rating = new ArrayList<String>();
        this.rating.add("0");
        this.id = UUID.randomUUID();
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){ return this.lastName; }
    public UUID getUUID(){
        return this.id;
    }
    public String getEmail(){return this.email;}
    public String getPrefLoc(){return this.prefLoc;}
    public String getPassword(){
        return this.password;
    }
    public String getMajor(){
        return this.major;
    }
    public String getSchool(){
        return this.school;
    }
    public String getClassYear(){
        return this.classYear;
    }
    public ArrayList<String> getRating(){
        return this.rating;
    }
    public ArrayList<String> getClasses(){
        return this.classes;
    }



}

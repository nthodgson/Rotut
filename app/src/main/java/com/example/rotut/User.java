package com.example.rotut;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class User  {
    private String username;
    private String name;
    private String UUID;
    private String password;
    private String major;
    private String school;
    private List<String> rating;
    private String classYear;
    private List<String> classes;

    public User(String newUsername, String newName, String newUUID, String newPassword,
                String newMajor, String newSchool, String newClassYear, List newClasses){
        this.username = newUsername;
        this.name = newName;
        this.UUID = newUUID;
        this.password = newPassword;
        this.major = newMajor;
        this.school = newSchool;
        this.classYear = newClassYear;
        this.classes = new ArrayList<>(newClasses);
        this.rating = Arrays.asList("0");
    }
    public String getUsername(){
        return this.username;
    }
    public String getName(){
        return this.name;
    }
    public String getUUID(){
        return this.UUID;
    }
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
    public List<String> getRating(){
        return this.rating;
    }
    public List<String> getClasses(){
        return this.classes;
    }



}

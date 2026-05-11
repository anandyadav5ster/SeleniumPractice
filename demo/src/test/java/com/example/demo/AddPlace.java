package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddPlace{

    private Location location;
    private int accuracy;
    private String address;
    private String name;
    
    @JsonProperty("_phone_number")
    private String phone_number;
  

    public Location getLocation(){
       return location;
    }
    public void setLocation(Location location){
        this.location = location;
    }
    public int getAccuracy(){
        return accuracy;
    }
    public void setAccuracy(int accuracy){
        this.accuracy = accuracy;
    }

    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String get_phone_number(){
        return phone_number;
    }
    public void set_phone_number(String phone_number){
        this.phone_number = phone_number;
    }
}
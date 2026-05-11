package com.example.demo;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class TestResponse {

    @Test
    public void testResponse(){
        // 1. Prepare Payload
        AddPlace addPlace = new AddPlace();
        addPlace.setName("Bangalore");
        addPlace.setAddress("Belathur");
        addPlace.setAccuracy(50);
        addPlace.set_phone_number("12345");
        
        Location location = new Location();
        location.setLat(-32.345678);
        location.setLng(30.427362);
        addPlace.setLocation(location); // CRITICAL: Set location inside addPlace

        // 2. Set Up Request
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        
        // Fix: Initialize RequestSpecification
        ResponsePojo response = given() 
        .log().all()
        .contentType(ContentType.JSON) // Better way to set header
        .body(addPlace)
        .when()
        .post("/maps/api/place/add/json")
        .then().log().all()
        .assertThat().statusCode(200) // Add assertions
        .extract().as(ResponsePojo.class);
        
        // 3. Output Results
        System.out.println(response.getStatus());
        System.out.println(response.getPlaceId());
    }
}

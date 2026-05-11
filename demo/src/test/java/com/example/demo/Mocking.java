package com.example.demo;

import org.testng.annotations.Test;

import com.github.tomakehurst.wiremock.WireMockServer;

import io.restassured.RestAssured;

// Essential Static Imports
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class Mocking{

    @Test
    public void testMockingUser(){
           // 1. Start the mock server on a specific port
WireMockServer wireMockServer = new WireMockServer(8080);
wireMockServer.start();

// 2. Define the "Stub" (the mock response)
wireMockServer.stubFor(get(urlEqualTo("/api/user/1"))
    .willReturn(aResponse()
        .withStatus(200)
        .withHeader("Content-Type", "application/json")
        .withBody("{ \"id\": 1, \"name\": \"Mocked User\" }")));

// 3. Test using REST Assured
RestAssured.baseURI = "http://localhost:8080";
// Option 1: Automatic logging to console
            Response response = given()
                .log().all() // Logs the Request details
            .when()
                .get("/api/user/1")
            .then()
                .log().all() // Logs the Response details (Status, Headers, Body)
                .statusCode(200)
                .body("name", equalTo("Mocked User"))
                .extract().response();
// Assert the mocked data
System.out.println(response);

given()
.when()
    .get("/api/user/1")
.then()
    .log().all()
    .statusCode(200)
    // This checks if the response structure matches your JSON file
    
    .body(matchesJsonSchemaInClasspath("user-schema.json")); 

    System.out.println("Schema validation passed");

wireMockServer.stop();
System.out.println("test passed");
    }
}
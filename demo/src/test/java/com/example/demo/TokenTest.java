package com.example.demo;
import io.restassured.response.Response;


public class TokenTest {

    String token = TokenGeneration.getAccessToken();

    Response response;

    @Test
    public getResponse(){
        response = given().auth().oauth2(token)
        .when()
        .get("https://example.com/protected/resource")
        .then()
        .statusCode(200)
        .extract().response();
        System.out.println("Response: " + response.asString());
    }
}
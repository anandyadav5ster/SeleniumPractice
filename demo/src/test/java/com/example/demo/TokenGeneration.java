package com.example.demo;

import java.time.Instant;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TokenGeneration {

    public static String accessToken;
    public static Instant tokenExpiryTime;
    static Response response = null;
    static long expires_in;

    public static String getAccessToken() {

        if (accessToken == null || isTokenExpired()) {
            refreshAccessToken();
        }
        return accessToken;
    }

    public static boolean isTokenExpired() {
        return tokenExpiryTime == null || Instant.now().isAfter(tokenExpiryTime);
    }

    private static void refreshAccessToken() {
        response = RestAssured.given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("grant_type", "client_credentials")
                .formParam("client_id", "clientId")
                .formParam("secret_id", "secretID")
                .post("https://your-auth-server.com/oauth/token");

                accessToken = response.jsonPath().getString("access_token");
                int expiresIn = response.jsonPath().getInt("expires_in");
               
				tokenExpiryTime = Instant.now().plusSeconds(expires_in);
                System.out.println("Access Token: " + accessToken);
                System.out.println("Token Expiry Time: " + tokenExpiryTime);
       
    }
}

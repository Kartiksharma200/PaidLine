package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APIUtils {

    // Base URL can be loaded from config
    private static final String BASE_URL = "https://api.paidline.com";

    // Generic GET call with auth token
    public static Response getCallData(String endpoint, String token) {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .header("Authorization", "Bearer " + token)
                .get(endpoint);
    }
}

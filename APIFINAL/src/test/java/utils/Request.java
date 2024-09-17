package utils;

import constant.BookingEndpoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Request {


    public static Response getById(String endpoint, String id) {
        return RestAssured.given()
                .pathParam("id", id)
                .when()
                .get(endpoint + "/{id}")
                .then()
                .extract()
                .response();
    }

    public static Response post(String endpoint, String payload){
        RestAssured.baseURI = BookingEndpoints.BASE_URL;
        Response response = RestAssured
                .given().contentType(ContentType.JSON).body(payload)
                .when().post(endpoint);
        response.then().log().body();
        return response;
    }


}

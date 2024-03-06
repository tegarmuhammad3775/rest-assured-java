package azurewebsite.apiTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import org.testng.annotations.BeforeMethod;
import azurewebsite.data.baseUrl;
import azurewebsite.payload.user;

import static io.restassured.RestAssured.given;

public class Users  {
    baseUrl baseUrl = new baseUrl();
    Response response;
    user userData = new user();
    public int user_id;
    public String token;

    @BeforeMethod
    public void Setup(){
        RestAssured.baseURI = baseUrl.getAzureWebsiteAPI();
    }

    @Test
    public void createUser(){
        response = given()
                .header("Content-Type","application/json")
                .body(userData.createUsers().toJSONString())
                .when()
                .post("/api/v1/users")
                .then()
                .log().body()
                .statusCode(200)
                .extract().response();
        user_id = response.getBody().path("id");
        System.out.println("user id = "+user_id);
    }

    @Test
    public void getUserById(){
        response = given()
                .when()
                .get("/api/v1/user/"+user_id)
                .then()
                .statusCode(404)
                .extract().response();
        System.out.println(RestAssured.baseURI + "api/users/" + user_id);
    }




}

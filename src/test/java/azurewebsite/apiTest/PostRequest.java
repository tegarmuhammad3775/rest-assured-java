package azurewebsite.apiTest;


import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;


public class PostRequest {

    @Test
    public void postRequest(){
         Object response = given()
                 .header("Content-Type","application/json")
                 .body("12345")
                 .when()
                 .post("/api/users");

    }


}

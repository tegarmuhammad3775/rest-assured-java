import io.restassured.RestAssured;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;


public class postRequest {

    @Test
    public void postRequest(){
         Object response = given()
                 .header("Content-Type","application/json")
                 .body("12345")
                 .when()
                 .post("/api/users");

    }


}

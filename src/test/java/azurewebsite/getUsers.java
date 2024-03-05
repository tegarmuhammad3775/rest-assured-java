package azurewebsite;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class getUsers {
    @BeforeClass
    public void setup() {
        //Set base url
        RestAssured.baseURI = "https://fakerestapi.azurewebsites.net";
    }

    @Test
    public void testGetUser(){
        RestAssured
                .given()
                .when()
                .get("/api/v1/Users")
                .then()
                .log().body()
                .assertThat().statusCode(200); //assertion atau test scenario
    }
}

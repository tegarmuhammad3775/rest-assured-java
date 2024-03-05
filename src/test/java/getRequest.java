import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class getRequest {
    @BeforeClass
    public void setup() {
        //Set base url
        RestAssured.baseURI = "https://reqres.in";
    }

    @Test
    public void testGetUser(){
        RestAssured
                .given()
                .when()
                .get("/api/users?page=2")
                .then().log().body();
    }

    @Test
    public void testGetUserParams (){
        RestAssured
                .given()
                .queryParam("page","2")
                .when()
                .get("/api/users")
                .then().log().body();
    }

    @Test
    public static void getResponseStatus(){
        int statusCode = RestAssured
                .given()
                .queryParam("page","2")
                .when()
                .get("/api/users")
                .getStatusCode();

        System.out.println("The response status is "+statusCode);
        RestAssured.given().when().get("api/users").then().assertThat().statusCode(200);
    }
}

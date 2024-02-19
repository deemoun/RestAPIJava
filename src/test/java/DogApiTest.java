import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DogApiTest {

    @Test
    public void testRandomDogImage() {
        RestAssured.baseURI = "https://dog.ceo/api/breeds/image/random";

        Response response = given()
                .when()
                .get()
                .then()
                .statusCode(200)
                .body("status", equalTo("success"))
                .extract().response(); // Extracts the full response for further processing

        String imageUrl = response.jsonPath().getString("message");
        System.out.println("Random Dog Image URL: " + imageUrl); // Prints the URL to the console
    }
}

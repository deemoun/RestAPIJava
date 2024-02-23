import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.given;

public class MoscowWeatherFetcher {

    public static void main(String[] args) {
        RestAssured.baseURI = "http://www.7timer.info/bin/api.pl";

        double longitude = 37.6173;
        double latitude = 55.7558;

        Response response = given()
                .queryParam("lon", longitude)
                .queryParam("lat", latitude)
                .queryParam("product", "civillight")
                .queryParam("output", "json")
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .response();

        System.out.println(response.asPrettyString()); // Debugging output
    }
}
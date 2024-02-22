import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.closeTo;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.Builder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StoreApiTest {

    @BeforeAll
    public static void setup() {
        baseURI = "https://fakestoreapi.com";
    }

    @Test()
    @Builder
    public void createProductTest() {
        Product product = Product.builder()
                .title("Beer and Chips")
                .price(16)
                .build();

        given().
                contentType(ContentType.JSON).
                body(product).
                when().
                post("/products").
                then().
                statusCode(200).
                body("title", equalTo(product.getTitle())).
                body("price", equalTo(product.getPrice()));
    }

    @Test
    public void createAndCheckProductTest() {
        // Создание объекта продукта
        Product product = Product.builder()
                .title("Backpack and Headphones")
                .price(16)
                .build();

        // Отправка запроса на создание продукта и получение ответа
        Response response = given()
                .contentType("application/json")
                .body(product)
                .when()
                .post("/products")
                .then()
                .extract().response();

        // Извлечение данных из ответа
        JsonPath jsonResponse = response.jsonPath();
        int actualPrice = jsonResponse.get("price");
        String actualProduct = jsonResponse.get("title");

        // Вывод информации о продукте и цене в консоль
        System.out.println("Product: " + actualProduct + ", Price: " + actualPrice);
    }
}

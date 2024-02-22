import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
    private int id;
    private String title;
    private int price;
    // Lombok автоматически генерирует геттеры, сеттеры и другие методы
}

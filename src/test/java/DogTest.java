import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class DogTest {

    @Test
    public void testBean() {
        Dog myDog = new Dog();
        myDog.setName("John");
        myDog.setAge(30);

        assertEquals("John", myDog.getName());
        assertEquals(30, myDog.getAge());
    }
}

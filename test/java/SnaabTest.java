import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class SnaabTest {
    private final Saab95 shitCar = new Saab95();


    @Test
    void testNumOfDoors(){
        assertEquals(2, shitCar.getNrDoors());
    }

}

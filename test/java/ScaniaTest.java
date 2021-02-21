
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class ScaniaTest {

    Truck scania = new Scania();

    /**
     * Test increment speed when angle of platform is not 0
     * Expected to fail when trying to increment speed
     */
    @Test
    public void testIncrementSpeedWithAngleGreaterThanZero() {
        scania.setAngle(50);
        scania.gas(.6);
        Assertions.assertEquals(0, scania.getCurrentSpeed());
    }

    /**
     * Test increment speed when angle of platform is 0
     * Expected to be able to increment speed properly
     */
    @Test
    public void testIncrementSpeedWithAngleOfZero() {
        scania.setAngle(0);
        scania.gas(.6);
        // todo assert true check >= !!!!!
        Assertions.assertEquals(0.6, scania.getCurrentSpeed());
    }

    @Test
    public void testLoadCar(){
        List<Car> cars = new ArrayList<>();
        for(int i = 0; i < 3;i++){
            cars.add(new Volvo240());
        }
        for (Car c:cars
             ) {
            scania.load(c);
        }
        Assertions.assertEquals(scania.getLoad().getFirst(), cars.get(0));
        Assertions.assertEquals(scania.getLoad().getLast(), cars.get(2));
    }
}

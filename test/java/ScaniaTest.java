import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ScaniaTest {

    LoadingTruck scania = new Scania();

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
        Assertions.assertEquals(0.6, scania.getCurrentSpeed());
    }
}

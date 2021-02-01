import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Scania truck test
 */
public class ScaniaTest {
    LoadingTruck scania = new Scania();

    /**
     * Test increment speed when truck speed is > 0
     */
    @Test
    public void testIncrementSpeedWithPositiveVelocity() {
        scania.gas(.6);
        Assertions.assertFalse(scania.getPlatform().setAngle(scania,45));
    }

    /**
     * Test increment speed when truck is in standstill
     */
    @Test
    public void testIncrementSpeedWhenStandstill() {
        scania.brake(2);
        Assertions.assertTrue(scania.getPlatform().setAngle(scania,45));
    }
}

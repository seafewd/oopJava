import org.junit.jupiter.api.Assertions;

/**
 * Scania truck test
 */
public class ScaniaTest {
    LoadingTruck scania = new Scania();

    /**
     * Test increment speed when truck
     */
    public void testIncrementSpeedWithPositiveVelocity() {
        scania.gas(.6);
        Assertions.assertFalse(scania.getPlatform().setAngle(scania,45));
    }
}

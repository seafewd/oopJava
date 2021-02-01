import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Saab95 test class
 */
public class SaabTest {
    private final Saab95 saab = new Saab95();

    /**
     * Test method setTurboOn
     */
    @Test
    public void testSetTurboOn() {
        saab.setTurboOn();
        Assertions.assertTrue(saab.turboOn);
    }

    /**
     * Test method setTurboOff
     */
    @Test
    public void testSetTurboOff() {
        saab.setTurboOff();
        Assertions.assertFalse(saab.turboOn);
    }

    /**
     * Test method speedFactor (with turbo off)
     */
    @Test
    public void testSpeedfactorWithoutTurbo() {
        saab.setTurboOff();
        Assertions.assertEquals(1.25, saab.speedFactor());
    }

    /**
     * Test method speedFactor (with turbo on)
     */
    @Test
    public void testSpeedfactorWithTurbo() {
        saab.setTurboOn();
        Assertions.assertEquals(1.625, saab.speedFactor());
    }
}

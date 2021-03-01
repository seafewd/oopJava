

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
        saab.toggleTurbo();
        Assertions.assertTrue(saab.getTurbo().isTurboOn());
    }

    /**
     * Test method setTurboOff
     */
    @Test
    public void testSetTurboOff() {
        saab.toggleTurbo();
        Assertions.assertFalse(saab.getTurbo().isTurboOn());
    }

    /**
     * Test method speedFactor (with turbo off)
     */
    @Test
    public void testSpeedfactorWithoutTurbo() {
        saab.toggleTurbo();
        Assertions.assertEquals(1.25, saab.speedFactor());
    }

    /**
     * Test method speedFactor (with turbo on)
     */
    @Test
    public void testSpeedfactorWithTurbo() {
        saab.toggleTurbo();
        Assertions.assertEquals(1.625, saab.speedFactor());
    }
}

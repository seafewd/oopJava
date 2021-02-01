import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Volvo240 test class
 */
public class VolvoTest {
    private final Volvo240 volvo = new Volvo240();

    /**
     * Test method speedFactor
     */
    @Test
    public void testSpeedfactor() {
        Assertions.assertEquals(1.25, volvo.speedFactor());
    }
}

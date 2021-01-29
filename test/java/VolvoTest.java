import org.junit.Test;
import org.junit.jupiter.api.Assertions;

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

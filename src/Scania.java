import java.awt.*;

/**
 * A type of Vehicle
 * Extends Vehicle which implements Movable
 */
public class Scania extends Truck {

    /**
     * Default constructor
     */
    public Scania() {
        super(2, 300, 0, Color.WHITE, "Scania", 3900, 5);
    }

    public Scania(double xPos, double yPos) {
        super(xPos, yPos,2, 300, 0, Color.WHITE, "Scania", 3900, 5);
    }

    @Override
    public double speedFactor() {
        return enginePower * 0.01;
    }
}

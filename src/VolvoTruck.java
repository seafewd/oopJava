import java.awt.*;

/**
 * A type of Vehicle
 * Extends Vehicle which implements Movable
 */
public class VolvoTruck extends Truck {

    /**
     * Default constructor
     */

    public VolvoTruck() {
        super(2, 300, 0, Color.BLACK, "Volvo Truckerino", 6250, 20);
    }

    public VolvoTruck(double xPos, double yPos) {
        super(xPos, yPos, 2, 300, 0, Color.BLACK, "Volvo Truckerino", 6250, 20);
    }


    @Override
    public double speedFactor() {
        return 0;
    }
}

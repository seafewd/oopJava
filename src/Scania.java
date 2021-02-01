import java.awt.*;

/**
 * A type of MotorVehicle
 * Extends Vehicle which implements Movable
 */
public class Scania extends LoadingTruck {

    /**
     * Default constructor
     */
    public Scania() {
        super(2, 300, 0, Color.WHITE, "Scania");
    }
}

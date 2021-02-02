import java.awt.*;

/**
 * A type of MotorVehicle
 * Extends Vehicle which implements Movable
 */
public class VolvoTruck extends LoadingTruck {

    /**
     * Default constructor
     */
    public VolvoTruck() {
        super(2, 300, 0, Color.BLACK, "Volvo Truckerino");
    }

}

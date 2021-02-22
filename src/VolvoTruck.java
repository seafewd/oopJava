import java.awt.*;

/**
 * A type of Vehicle
 * Extends Vehicle which implements Movable
 */
public class VolvoTruck extends AbstractVehicle implements Transporter<Car>, Transportable{

    DefaultTransporter<Car> dt;

    public VolvoTruck(double xPos, double yPos) {
        this.dt = new DefaultTransporter<>(xPos, yPos, 2, 300, 0, Color.BLACK, "Volvo Truckerino", 6250, 20);
    }


    public VolvoTruck() {
        this.dt = new DefaultTransporter<>(2, 300, 0, Color.BLACK, "Volvo Truckerino", 6250, 20);
    }
}

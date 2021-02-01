import java.awt.*;

/**
 * A type of car
 * Extends Vehicle which implements Movable
 */
public class Volvo240 extends MotorVehicle {
    private final static double trimFactor = 1.25;

    /**
     * Default constructor
     */
    public Volvo240(){
        super(4, 100, 0, Color.black, "Volvo240");
    }

    /**
     * Set speed factor depending on properties of car
     * @return speed factor (double)
     */
    @Override
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }
}

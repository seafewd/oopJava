import java.awt.*;

/**
 * A type of Vehicle
 * Extends Vehicle which implements Movable
 */
public class Volvo240 extends Car {
    private final static double trimFactor = 1.25;

    /**
     * Default constructor
     */
    public Volvo240(){
        super(4, 100, 0, Color.black, "Volvo240", 2250);
    }

    /**
     * Set speed factor depending on properties of Vehicle
     * @return speed factor (double)
     */
    @Override
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }


    @Override
    public void driveBy() {
        System.out.println("English, motherfucker! Do you speak it!?");
    }
}

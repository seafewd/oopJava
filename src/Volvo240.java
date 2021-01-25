import java.awt.*;

/**
 * A type of car
 * Extends Car which implements Movable
 */
public class Volvo240 extends Car {
    private final static double trimFactor = 1.25;

    /**
     * Default constructor
     */
    public Volvo240(){
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
    }

    /**
     * Set speed factor depending on properties of car
     * @return speed factor (double)
     */
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

    /**
     * Increment speed
     * @param amount The amount with which to increment
     */
    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    /**
     * Decrement speed
     * @param amount The amount with which to decrement
     */
    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    /**
     * Give more gas
     * @param amount The amount with which to give gas
     */
    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    /**
     * Brake car
     * @param amount The amount with which to brake
     */
    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
}

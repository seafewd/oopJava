import java.awt.*;

/**
 * A type of car
 * Extends Car which implements Movable
 */
public class Saab95 extends Car {
    private boolean turboOn;

    /**
     * Default constructor
     */
    public Saab95(){
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
	    turboOn = false;
        modelName = "Saab95";
        stopEngine();
    }

    /**
     * Set turbo on
     */
    public void setTurboOn(){
	    turboOn = true;
    }

    /**
     * Set turbo off
     */
    public void setTurboOff(){
	    turboOn = false;
    }

    /**
     * Set speed factor
     * @return
     */
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    /**
     * Increment speed
     * @param amount The amount with which to increment
     */
    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    /**
     * Decrement speed
     * @param amount The amount with which to decrement
     */
    public void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    /**
     * Floor it
     * @param amount The amount with which to give gas
     */
    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    /**
     * Brake car
     * @param amount Amount with which to brake
     */
    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
}

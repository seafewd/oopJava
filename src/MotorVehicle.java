import java.awt.*;

/**
 * Parent class, handles all types of cars
 * Implements Movable for movement related issues
 */
public abstract class Car extends Vehicle implements Movable {

    // todo protected -> public where it makes sense

    /**
     * Number of doors on the car
     */
    protected int nrDoors;

    /**
     * Engine power of the car
     */
    protected double enginePower;

    /**
     * Default constructor
     * @param nrDoors       no. of doors
     * @param enginePower   engine power
     * @param currentSpeed  current speed
     * @param color         color
     * @param modelName     model name
     */
    public Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName) {
        super(currentSpeed, color, modelName, 0, 0);
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        stopEngine();
    }

    /**
     * Get number of doors
     * @return Number of doors
     */
    protected int getNrDoors(){
        return nrDoors;
    }

    /**
     * Get engine power of car
     * @return Engine power
     */
    protected double getEnginePower(){
        return enginePower;
    }


    /**
     * Start car engine
     */
    protected void startEngine(){
        currentSpeed = 0.1;
        System.out.println("Engine started.");
    }

    /**
     * Stop car engine
     */
    protected void stopEngine(){
        currentSpeed = 0;
        System.out.println("Engine stopped.");
    }

    /**
     * Increment speed
     * @param amount The amount with which to increment
     */
    protected void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    /**
     * Decrement speed
     * @param amount The amount with which to decrement
     */
    protected void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

}

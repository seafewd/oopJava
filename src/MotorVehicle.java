import java.awt.*;

/**
 * Parent class, handles all types of motor vehicles
 * Implements Movable for movement related issues
 */
public abstract class MotorVehicle extends Vehicle {

    /**
     * Engine power of the vehicle
     */
    protected double enginePower;

    /**
     * Default constructor
     * @param enginePower   engine power
     * @param currentSpeed  current speed
     * @param color         color
     * @param modelName     model name
     */
    public MotorVehicle(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName) {
        super(nrDoors, currentSpeed, color, modelName, 0, 0);
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        stopEngine();
    }

    /**
     * Get engine power of car
     * @return Engine power
     */
    protected double getEnginePower(){
        return enginePower;
    }

    @Override
    protected double speedFactor() {
        return enginePower * 0.01;
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
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    /**
     * Decrement speed
     * @param amount The amount with which to decrement
     */
    protected void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

}

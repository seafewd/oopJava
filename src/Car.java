import java.awt.*;

/**
 * Parent class, handles all types of cars
 * Implements Movable for movement related issues
 */
public abstract class Car implements Movable {
    /**
     * Where are we going next?
     */
    public direction currentDirection = direction.NORTH;
    /**
     * Number of doors on the car
     */
    protected int nrDoors;

    /**
     * Engine power of the car
     */
    protected double enginePower;

    /**
     * The current speed of the car
     */
    protected double currentSpeed;

    /**
     * Color of the car
     */
    protected Color color;

    /**
     * The car model name
     */
    protected String modelName;

    /**
     * Current x-position
     */
    protected int xPos;

    /**
     * Current y-position
     */
    protected int yPos;

    /**
     * Upper limit for applying gas
     */
    protected static final double GAS_LIMIT = 1;

    /**
     * Upper limit for applying brakes
     */
    protected static final double BRAKE_LIMIT = 1;

    /**
     * Default constructor
     * @param nrDoors       no. of doors
     * @param enginePower   engine power
     * @param currentSpeed  current speed
     * @param color         color
     * @param modelName     model name
     */
    public Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.xPos = 0;
        this.yPos = 0;
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
     * Get current speed of car
     * @return Current speed
     */
    protected double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * Get color of car
     * @return Color
     */
    protected Color getColor(){
        return color;
    }

    /**
     * Set the color of the car
     * @param clr Color to set
     */
    protected void setColor(Color clr){
        color = clr;
    }

    /**
     * Start car engine
     */
    protected void startEngine(){
        currentSpeed = 0.1;
        System.out.println("Engine started.");

    }
    public enum direction {
        NORTH, EAST, SOUTH, WEST;
        public direction turn_Right() {
            return values()[(ordinal()+1) % values().length];
        }
        public direction turn_Left() {
            return values()[(ordinal()-1) % values().length];
        }
    }

    /**
     * Stop car engine
     */
    protected void stopEngine(){
        currentSpeed = 0;
        System.out.println("Engine stopped.");
    }

    /**
     * Speed factor - varies depending on model
     * @return Speed factor
     */
    protected abstract double speedFactor();

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


    /**
     * Give gas
     * Only accepts positive values in [0,1]
     * @param amount The amount with which to give gas
     */
    protected void gas(double amount){
        if(isInLimit(0, GAS_LIMIT, amount) && amount > 0)
            incrementSpeed(amount);
    }

    /**
     * Gets a cars position
     * @param car The car you want to get a position of
     * @return Fancy string describing the exact position of the car
     */
    protected String getPosition(Car car) {
        return "Current position: (" + car.xPos + ", " + car.yPos + ").";
    }

    /**
     * Brake car
     * Only accepts positive values in [0,1]
     * @param amount Amount with which to brake
     */
    protected void brake(double amount){
        if(isInLimit(0, BRAKE_LIMIT, amount) && amount > 0)
            decrementSpeed(amount);
    }

    /**
     * Move the car
     */
    @Override
    public void move() {
        yPos++;
        System.out.println("Moving. " + getPosition(this));
    }

    /**
     * Make car turn left
     */
    @Override
    public void turnLeft() {
        currentDirection = currentDirection.turn_Left();
        System.out.println("Right turn. Facing " + currentDirection);
    }

    /**
     * Make car turn right
     */
    @Override
    public void turnRight() {
        currentDirection = currentDirection.turn_Right();
        System.out.println("Right turn. Facing " + currentDirection);
    }

    // Helper functions

    /**
     * Check if the value falls in the given range
     * @param lowerBound lower limit
     * @param upperBound upper limit
     * @param value to be checked
     * @return bool
     */
    protected boolean isInLimit(double lowerBound, double upperBound, double value){
        return (value >= lowerBound && value <= upperBound);
    }

}

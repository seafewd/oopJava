import java.awt.*;

public abstract class Vehicle implements Movable {

    /**
     * Number of doors on the vehicle
     */
    protected int nrDoors;

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
     * Current direction of car
     */
    protected Direction direction;

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
     * @param nrDoors
     * @param currentSpeed
     * @param color
     * @param modelName
     * @param xPos
     * @param yPos
     */
    public Vehicle(int nrDoors, double currentSpeed, Color color, String modelName, int xPos, int yPos) {
        this.nrDoors = nrDoors;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    /**
     * Get current speed of car
     * @return Current speed
     */
    protected double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * Get number of doors
     * @return Number of doors
     */
    protected int getNrDoors(){
        return nrDoors;
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
     * Speed factor - varies depending on model
     * @return Speed factor
     */
    protected abstract double speedFactor();

    protected abstract void incrementSpeed(double amount);

    protected abstract void decrementSpeed(double amount);

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
        if (currentSpeed > 0) {
            xPos--;
            System.out.println("Left turn. " + getPosition(this));
        }
    }

    /**
     * Make car turn right
     */
    @Override
    public void turnRight() {
        if (currentSpeed > 0) {
            xPos++;
            System.out.println("Right turn. " + getPosition(this));
        }
    }


    /**
     * Give gas
     * Only accepts values in [0,GAS_LIMIT]
     * @param amount The amount with which to give gas
     */
    protected void gas(double amount){
        if(isInLimit(0, GAS_LIMIT, amount) && amount > 0)
            incrementSpeed(amount);
    }

    /**
     * Gets a vehicle position
     * @param vehicle The car you want to get a position of
     * @return Fancy string describing the exact position of the vehicle
     */
    protected String getPosition(Vehicle vehicle) {
        return "Current position: (" + vehicle.xPos + ", " + vehicle.yPos + ").";
    }

    /**
     * Brake vehicle
     * Only accepts positive values in [0,1]
     * @param amount Amount with which to brake
     */
    protected void brake(double amount){
        if(isInLimit(0, BRAKE_LIMIT, amount) && amount > 0)
            decrementSpeed(amount);
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

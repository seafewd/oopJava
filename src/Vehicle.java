import java.awt.*;

/**
 * Parent class, handles all types of cars
 * Implements Movable for movement related issues
 */
public abstract class Vehicle implements Movable {

    /**
     * Number of doors on the Vehicle
     */
    private int nrDoors;

    /**
     * Engine power of the Vehicle
     */
    protected double enginePower;

    /**
     * The current speed of the Vehicle
     */
    protected double currentSpeed;

    /**
     * Color of the Vehicle
     */
    protected Color color;

    /**
     * The Vehicle model name
     */
    protected String modelName;

    /**
     * Current x-position
     */
    protected double xPos;

    /**
     * Current y-position
     */
    protected double yPos;

    /**
     * Gas limit
     */
    private static final double GAS_LIMIT = 1;

    /**
     * Brake Limit
     */
    private static final double BRAKE_LIMIT = 1;

    /**
     * The direction the Vehicle is facing
     * Should be initialized with length 1 to keep it that way
     */
    protected double[] direction;

    /**
     * Weight of Vehicle (kg)
     */
    private int weight;


    /**
     * Default constructor
     * @param nrDoors       no. of doors
     * @param enginePower   engine power
     * @param currentSpeed  current speed
     * @param color         color
     * @param modelName     model name
     */
    public Vehicle(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int weight) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = 0;
        this.color = color;
        this.modelName = modelName;
        this.xPos = 0;
        this.yPos = 0;
        this.direction = new double[]{1, 0};
        this.weight = weight;
        stopEngine();
    }

    /**
     * Get number of doors
     * @return Number of doors
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /**
     * Get engine power of Vehicle
     * @return Engine power
     */
    protected double getEnginePower(){
        return enginePower;
    }

    /**
     * Get current speed of Vehicle
     * The speed is the magnitude of the the velocity vector
     * @return Current speed
     */
    protected double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * Get current normalized direction.
     * If the speed is 0, the previous state is returned
     * @return direction
     */

    protected double[] getDirection(){
        return direction;
    }

    /**
     * Get color of Vehicle
     * @return Color
     */
    public Color getColor(){
        return color;
    }

    /**
     * Set the color of the Vehicle
     * @param clr Color to set
     */
    protected void setColor(Color clr){
        color = clr;
    }

    /**
     * Gets a Vehicle's position
     * @param vehicle The Vehicle you want to get a position of
     * @return Fancy string describing the exact position of the Vehicle
     */
    public String showPosition(Vehicle vehicle) {
        return "Current position: (" + vehicle.xPos + ", " + vehicle.yPos + ").";
    }

    /**
     * Get X pos
     * @return xPos
     */
    @Override
    public double getXPos() {
        return xPos;
    }

    /**
     * Get Y pos
     * @return yPos
     */
    @Override
    public double getYPos(){
        return yPos;
    }

    /**
     * Set X pos
     */
    @Override
    public void setXPos(double xPos) {
        this.xPos = xPos;
    }

    /**
     * Set X pos
     */
    @Override
    public void setYPos(double yPos) {
        this.yPos = yPos;
    }

    /**
     * Set direction
     * @param direction vector to be set
     */
    protected void setDirection(double[] direction){
        this.direction = direction;
    }


    /**
     * Start Vehicle engine
     */
    protected void startEngine(){
        currentSpeed = 0.1;
        System.out.println("Engine started.");
    }

    /**
     * Stop Vehicle engine
     */
    public void stopEngine(){
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
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
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
     * Only accepts values in [0,GAS_LIMIT]
     * @param amount The amount with which to give gas
     */
    public void gas(double amount){
        if(isInLimit(0, GAS_LIMIT, amount) && amount > 0)
            incrementSpeed(amount);
    }

    /**
     * Brake car
     * Only accepts positive values in [0,1]
     * @param amount Amount with which to brake
     */
    public void brake(double amount){
        if(isInLimit(0, BRAKE_LIMIT, amount) && amount > 0)
            decrementSpeed(amount);
    }

    /**
     * Move the Vehicle
     * Sets the new position
     * Direction vector scaled by speed
     */
    @Override
    public void move() {
        xPos += getDirection()[0] * getCurrentSpeed();
        yPos += getDirection()[1] * getCurrentSpeed();
        System.out.println("Moving. " + showPosition(this));
    }

    /**
     * Make Vehicle turn left. Only turns if the speed is not 0
     */
    @Override
    public void turnLeft() {
        if (currentSpeed > 0) {
            setDirection(rotateVector(getDirection(), Math.PI/2));
            System.out.println("Left turn. " + showPosition(this));
        }
    }

    /**
     * Make car turn right
     */
    @Override
    public void turnRight() {
        if (currentSpeed > 0) {
            setDirection(rotateVector(getDirection(), -Math.PI/2));
            System.out.println("Left turn. " + showPosition(this));
        }
    }

    // -------- Set/get


    // ---------- Helper functions


    /**
     * Rotate vector
     * A*v = v', where A is the rotation matrix and v is the velocity vector
     *
     * The math:
     * |cos r -sin r|  * |dx| = |dx'|
     * |sin r  cos r|    |dy|   |dy'|
     *
     * @param vector to be rotated
     * @param radians how much to rotate
     * @return transformed vector
     */

    protected double[] rotateVector(double[] vector, double radians){

        double dx = vector[0];
        double dy = vector[1];
        // casted to long for correct values (otherwise we get long decimals)
        long newDx = (long)(dx * Math.cos(radians) - dy * Math.sin(radians));
        long newDy = (long)(dx * Math.sin(radians) + dy * Math.cos(radians));

        return new double[]{newDx, newDy};
    }

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

    /**
     * Print the current direction
     */

    protected void showDirection(){
        System.out.println("Current direction: (" + getDirection()[0] +  ", " + getDirection()[1] + ")");
    }

}

public abstract class AbstractMovable implements Movable {

    /**
     * Move power of the movable object (horse power, energy, whatever...)
     */
    protected double movePower;

    /**
     * The current speed of the Vehicle
     */
    protected double currentSpeed;

    /**
     * Current x-position
     */
    protected int xPos;

    /**
     * Current y-position
     */
    protected int yPos;

    /**
     * The direction the Vehicle is facing
     * Should be initialized with length 1 to keep it that way
     */
    protected double[] direction;

    /**
     * Weight of AbstractMovable (kg)
     */
    protected int weight;

    /**
     * Default constructor
     */
    public AbstractMovable(int weight) {
        this.xPos = 0;
        this.yPos = 0;
        this.direction = new double[]{1, 0};
        this.weight = weight;
        this.currentSpeed = 0;
        this.movePower = 1;
    }

    /**
     * Constructor with predef. values
     * @param currentSpeed  current speed
     * @param movePower     move power
     */
    public AbstractMovable(double currentSpeed, double movePower, int weight) {
        this.xPos = 0;
        this.yPos = 0;
        this.weight = weight;
        this.direction = new double[]{1, 0};
        this.currentSpeed = currentSpeed;
        this.movePower = movePower;
    }

    /**
     * Constructor with predef. values + position
     * @param xPos         xpos
     * @param yPos         ypos
     * @param currentSpeed current speed
     * @param movePower    move power
     */
    public AbstractMovable(int xPos, int yPos, double currentSpeed, double movePower, int weight) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.weight = weight;
        this.direction = new double[]{1, 0};
        this.currentSpeed = currentSpeed;
        this.movePower = movePower;
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
     * Gets a Vehicle's position
     * @param am The Vehicle you want to get a position of
     * @return Fancy string describing the exact position of the Vehicle
     */
    public String showPosition(AbstractMovable am) {
        return "Current position: (" + am.xPos + ", " + am.yPos + ").";
    }

    /**
     * Get X pos
     * @return xPos
     */
    @Override
    public int getXPos() {
        return xPos;
    }

    /**
     * Get Y pos
     * @return yPos
     */
    @Override
    public int getYPos(){
        return yPos;
    }

    /**
     * Set X pos
     */
    @Override
    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    /**
     * Set X pos
     */
    @Override
    public void setYPos(int yPos) {
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
     * Speed factor - varies depending on model
     * @return Speed factor
     */
    public double speedFactor() {
        return movePower * 0.01;
    }

    /**
     * Increment speed
     * @param amount The amount with which to increment
     */
    protected void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, movePower);
    }

    /**
     * Decrement speed
     * @param amount The amount with which to decrement
     */
    protected void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
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
        //System.out.println("Moving. " + showPosition(this));
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
            System.out.println("Right turn. " + showPosition(this));
        }
    }

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

    protected void setCurrentSpeed(double amount) {
        currentSpeed = amount;
    }


}

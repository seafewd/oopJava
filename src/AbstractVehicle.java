import java.awt.*;

/**
 * Parent class, handles all types of cars
 * Implements Movable for movement related issues
 */
public abstract class AbstractVehicle extends AbstractMovable {

    /**
     * Number of doors on the Vehicle
     */
    protected int nrDoors;

    /**
     * Engine power of the Vehicle
     */
    protected double enginePower;

    /**
     * Color of the Vehicle
     */
    protected Color color;

    /**
     * The Vehicle model name
     */
    protected String modelName;


    /**
     * Gas limit
     */
    private static final double GAS_LIMIT = 1;

    /**
     * Brake Limit
     */
    private static final double BRAKE_LIMIT = 1;


    /**
     * Weight of Vehicle (kg)
     */
    protected int weight;

    /**
     * Max load weight
     */
    protected int maxLoad;

    /**
     * Default constructor
     * @param nrDoors       no. of doors
     * @param enginePower   engine power
     * @param currentSpeed  current speed
     * @param color         color
     * @param modelName     model name
     */

    public AbstractVehicle(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int weight) {
        this.xPos = 0;
        this.yPos = 0;
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.direction = new double[]{1, 0};
        this.weight = weight;
        stopEngine();
    }

    public AbstractVehicle(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int weight, int maxLoad) {
        this.xPos = 0;
        this.yPos = 0;
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.direction = new double[]{1, 0};
        this.weight = weight;
        this.maxLoad = maxLoad;
        stopEngine();
    }

    /**
     * With set position
     * @param xPos
     * @param yPos
     * @param nrDoors
     * @param enginePower
     * @param currentSpeed
     * @param color
     * @param modelName
     * @param weight
     */
    public AbstractVehicle(double xPos, double yPos, int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int weight) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.direction = new double[]{1, 0};
        this.weight = weight;
        stopEngine();
    }

    public AbstractVehicle(double xPos, double yPos, int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int weight, int maxLoad) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.direction = new double[]{1, 0};
        this.weight = weight;
        this.maxLoad = maxLoad;
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


}

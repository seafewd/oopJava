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
     * Constrctor
     * @param nrDoors   Doors
     * @param color     Color
     * @param modelName Model name
     * @param weight    Weight
     */
    public AbstractVehicle(int nrDoors, Color color, String modelName, int weight) {
        super(weight);
        this.nrDoors = nrDoors;
        this.color = color;
        this.modelName = modelName;
        stopEngine();
    }

    /**
     * Constructor 2
     * @param nrDoors      Doors
     * @param movePower    Move power
     * @param currentSpeed Current speed
     * @param color        Color
     * @param modelName    Model name
     * @param weight       Weight
     */
    public AbstractVehicle(int nrDoors, double movePower, double currentSpeed, Color color, String modelName, int weight) {
        super(currentSpeed, movePower, weight);
        this.nrDoors = nrDoors;
        this.movePower = movePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        stopEngine();
    }

    /**
     * Constructor 3
     * @param xPos         x pos
     * @param yPos         y pos
     * @param nrDoors      Doors
     * @param movePower    Move power
     * @param currentSpeed Current speed
     * @param color        Color
     * @param modelName    Model name
     * @param weight       Weight
     */
    public AbstractVehicle(int xPos, int yPos, int nrDoors, double movePower, double currentSpeed, Color color, String modelName, int weight) {
        super(xPos, yPos, currentSpeed, movePower, weight);
        this.nrDoors = nrDoors;
        this.color = color;
        this.modelName = modelName;
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
        return movePower;
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

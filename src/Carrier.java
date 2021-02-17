import java.awt.*;
import java.util.Deque;

/**
 * Carrier class
 * Can load other Cars for transportation etc.
 */
public abstract class Carrier extends Vehicle {

    /**
     * The carrier's cargo
     */
    protected Deque<Car> load;

    /**
     * Loading distance
     */
    private final static double LOADING_DISTANCE = 20;

    /**
     * Maximum amount of Cars that will fit
     */
    protected int maxCars;

    /**
     * Default constructor
     * @param nrDoors           No. of doors on transport
     * @param enginePower       Engine power
     * @param currentSpeed      Current speed
     * @param color             Color
     * @param modelName         Model name
     * @param weight            Weight
     * @param maxCars           Maximum no. of cars
     * @param load              Current load
     */
    public Carrier(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int weight, int maxCars, Deque<Car> load) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, weight);
        this.maxCars = maxCars;
        this.load = load;
    }

    public Carrier(double xPos, double yPos, int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int weight, int maxCars, Deque<Car> load) {
        super(xPos, yPos, nrDoors, enginePower, currentSpeed, color, modelName, weight);
        this.maxCars = maxCars;
        this.load = load;
    }

    /**
     * Check if car is close enough to the transport to be able to be loaded onto it
     * @param car   Car to check
     * @return      Proximity check
     */
    public boolean isCloseEnoughToLoad(Car car) {
        boolean isCloseX = this.xPos < car.getXPos() + LOADING_DISTANCE && this.xPos > car.getXPos() - LOADING_DISTANCE;
        boolean isCloseY = this.yPos < car.getYPos() + LOADING_DISTANCE && this.yPos > car.getYPos() - LOADING_DISTANCE;
        return isCloseX && isCloseY;
    }

    /**
     * Get cargo load
     * @return  Cargo load
     */
    public Deque<Car> getLoad() {
        return load;
    }

    /**
     * Check if loading is possible (e.g. not exceeding maximum amount of cars already in transport)
     */
    public boolean transportNotFull() {
        if (load.size() < maxCars) {
            return true;
        }
        System.out.println("Transport is full!");
        return false;
    }

    /**
     * Load the transport with a car
     * @param car   Car to load
     */
    protected abstract boolean loadCar(Car car);

    /**
     * Move transporter's cargo
     */
    protected void moveLoad() {
        for (Car c : load) {
            c.setXPos(this.xPos);
            c.setYPos(this.yPos);
        }
    }

    /**
     * Unload vehicles
     */
    public abstract void unloadVehicles(int vehiclesToUnload);

    /**
     * Move the Vehicle
     * Move all its cargo at the same time
     */
    @Override
    public void move() {
        super.move();
        moveLoad();
    }

    /**
     * Turn left
     * Move all its cargo at the same time
     */
    @Override
    public void turnLeft() {
        super.turnLeft();
        moveLoad();
    }

    /**
     * Move right
     * Move all its cargo at the same time
     */
    @Override
    public void turnRight() {
        super.turnRight();
        moveLoad();
    }
}

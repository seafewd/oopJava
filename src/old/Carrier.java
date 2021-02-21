package old;

import java.awt.*;
import java.util.Deque;

/**
 * old.Carrier class
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
}

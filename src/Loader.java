import java.awt.*;

/**
 * Loader class
 * Can load other vehicles for transportation etc.
 */
public abstract class Loader extends Vehicle {

    /**
     * Loading distance
     */
    protected static double LOADING_DISTANCE = 20;

    /**
     * Maximum amount of Cars that will fit
     */
    protected static int MAX_CARS;

    public Loader(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int weight, int maxCars) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, weight);
        MAX_CARS = maxCars;
    }

    /**
     * Load the transport with a car
     * @param car   Car to load
     */
    protected abstract void loadCar(Car car);

    /**
     * Check if loading is possible (e.g. not exceeding maximum amount of cars already in transport)
     */
    protected abstract boolean checkIfLoadPossible();


    /**
     * Set speed factor depending on properties of LoadingTruck
     * @return speed factor (double)
     */
    @Override
    public double speedFactor(){
        return enginePower * 0.01;
    }

    /**
     * Move transporter's cargo
     */
    protected abstract void moveLoad();


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

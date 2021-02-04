import java.awt.*;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Loader class
 * Can load other vehicles for transportation etc.
 */
public abstract class Loader extends Vehicle {

    /**
     * Loading distance
     */
    protected static double LOADING_DISTANCE = 20;

    public Loader(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int weight) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, weight);
    }

    protected abstract void loadCar(Car car);

    /**
     * Set speed factor depending on properties of LoadingTruck
     * @return speed factor (double)
     */
    @Override
    public double speedFactor(){
        return enginePower * 0.01;
    }

    /**
     * Move load using Queue
     * @param load  Cargo
     */
    protected void moveLoad(Queue<Vehicle> load) {
        for (Vehicle v : load) {
            v.setXPos(this.xPos);
            v.setYPos(this.yPos);
        }
    }

    /**
     * Move load using ArrayDeque
     * @param load  Cargo
     */
    protected void moveLoad(ArrayDeque<Vehicle> load) {
        for (Vehicle v : load) {
            v.setXPos(this.xPos);
            v.setYPos(this.yPos);
        }
    }

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

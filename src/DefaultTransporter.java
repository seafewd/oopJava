import java.awt.*;
import java.util.Collection;

public class DefaultTransporter<T extends Transportable> implements Transporter<Transportable> {

    Collection<Transportable> load;

    /**
     * Loading distance
     */
    private final static double LOADING_DISTANCE = 20;

    /**
     * Maximum amount of Cars that will fit
     */
    protected int maxLoad;

    public DefaultTransporter(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int weight, int maxLoad) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, weight, maxLoad);
    }


    public DefaultTransporter(double xPos, double yPos, int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int weight, int maxLoad) {
        super(xPos, yPos, nrDoors, enginePower, currentSpeed, color, modelName, weight, maxLoad);
    }

    /**
     * Loads the given Car if it's in proximity and if the transport isn't full
     * Distance is set by LOADING_DISTANCE
     * @param t Transportable to be loaded
     */
    public boolean load(Transportable t){
        if (transportNotFull() && isCloseEnoughToLoad(t)) {
            load.add(t);
            return true;
        }
        return false;
    }

    /**
     * Unload the cars currently in truck cargo
     * @param carsToUnload number of vehicles to unload
     */
    public Transportable unload(int carsToUnload) {
        double loaderXPos = this.getXPos();
        double loaderYPos = this.getYPos();

        for (int i = carsToUnload; i > 0; i--) {
            Transportable c = load.removeFirst();
            c.setXPos(loaderXPos + i);
            c.setYPos(loaderYPos);
            c.setDirection(direction);
        }
    }


    /**
     * Check if car is close enough to the transport to be able to be loaded onto it
     * @param car   Car to check
     * @return      Proximity check
     */
    public boolean isCloseEnoughToLoad(Transportable t) {
        boolean isCloseX = this.xPos < t.getXPos() + LOADING_DISTANCE && this.xPos > t.getXPos() - LOADING_DISTANCE;
        boolean isCloseY = this.yPos < t.getYPos() + LOADING_DISTANCE && this.yPos > t.getYPos() - LOADING_DISTANCE;
        return isCloseX && isCloseY;
    }

    /**
     * Get cargo load
     * @return  Cargo load
     */
    public Collection<Transportable> getLoad() {
        return load;
    }

    /**
     * Check if loading is possible (e.g. not exceeding maximum amount of cars already in transport)
     */
    public boolean transportNotFull() {
        if (load.size() < maxLoad) {
            return true;
        }
        System.out.println("Transport is full!");
        return false;
    }

    /**
     * Move transporter's cargo
     */
    protected void moveLoad() {
        for (Transportable t : load) {
            t.setXPos(this.xPos);
            t.setYPos(this.yPos);
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

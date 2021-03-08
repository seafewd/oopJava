import java.awt.*;
import java.util.Collection;
import java.util.Iterator;

public abstract class AbstractTruck extends AbstractVehicle {

    /**
     * Ramp attached to Truck
     */
    private final Ramp ramp;

    /**
     * Loader attached to Truck
     */
    private final Loader<AbstractCar> loader;

    private VehicleState rampRaised;
    private VehicleState rampLowered;
    private VehicleState gas;

    private VehicleState vehicleState;


    public AbstractTruck(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int weight, int loadingDistance) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, weight);
        this.ramp = new Ramp(this);
        this.loader = new Loader<>(loadingDistance);
        rampRaised = new RampRaised(this);
        rampLowered = new RampLowered(this);
        vehicleState = rampRaised;
    }

    public AbstractTruck(int xPos, int yPos, int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int weight, int loadingDistance) {
        super(xPos, yPos, nrDoors, enginePower, currentSpeed, color, modelName, weight);
        this.ramp = new Ramp(this);
        this.loader = new Loader<>(loadingDistance);
        rampRaised = new RampRaised(this);
        rampLowered = new RampLowered(this);
        vehicleState = rampRaised;
    }

    public void setVehicleState(VehicleState newVehicleState) { vehicleState = newVehicleState; }

    public VehicleState getVehicleState() { return vehicleState; }
    public VehicleState getRampRaisedState() { return rampRaised; }
    public VehicleState getRampLoweredState() { return rampLowered; }
    public VehicleState getGasState() { return gas; }

    /**
     * Check if car is close enough to the transport to be able to be loaded onto it
     * @param ac    AbstractCar to check
     * @return      Proximity check
     */
    public boolean isCloseEnoughToLoad(AbstractCar ac) {
        boolean isCloseX = this.xPos < ac.getXPos() + loader.getLoadingDistance() && this.xPos > ac.getXPos() - loader.getLoadingDistance();
        boolean isCloseY = this.yPos < ac.getYPos() + loader.getLoadingDistance() && this.yPos > ac.getYPos() - loader.getLoadingDistance();
        return isCloseX && isCloseY;
    }

    public Ramp getRamp() {
        return ramp;
    }

    public void setRampAngle(int degrees) {
        ramp.setAngle(degrees);
        if (degrees == 0)
            vehicleState = rampRaised;
        else
            vehicleState = rampLowered;
    }

    /**
     * Increment speed
     * Require that the truck platform is down in order to increment speed
     * @param amount The amount with which to increment
     */
/*    @Override
    protected void incrementSpeed(double amount){
        if (ramp.getAngle() == 0)
            super.incrementSpeed(amount);
        else
            System.out.println("Can't move unless platform angle is 0");
    }*/
    @Override
    protected void incrementSpeed(double amount){
        if (vehicleState == rampRaised)
            super.incrementSpeed(amount);
        else
            System.out.println("Can't move unless platform angle is 0");
    }

    /**
     * Loads the given Vehicle if the Vehicle is close enough, the platform is lowered and if it's not a truck.
     * Distance is set by LOADING_DISTANCE
     * @param ac AbstractCar to be loaded
     */
    public boolean load(AbstractCar ac) {
        if (loader.transportNotFull() && isCloseEnoughToLoad(ac) && ramp.getAngle() == 0)
            return loader.load.add(ac);
        return false;
    }

    /**
     * Unload the vehicles currently in truck cargo
     * TODO TEST THIS!!!!!!!!
     * @param vehiclesToUnload number of vehicles to unload
     */
    public void unload(int vehiclesToUnload) {
        int loaderXPos = this.getXPos();
        int loaderYPos = this.getYPos();
        Collection<AbstractCar> load = loader.getLoad();
        Iterator<AbstractCar> it = load.iterator();

        for (int i = vehiclesToUnload; i > 0; i--) {
            if (!load.isEmpty()) {
                AbstractCar ac = it.next();
                ac.setXPos(loaderXPos + i);
                ac.setYPos(loaderYPos);
                ac.setDirection(direction);
                it.remove();
            }
        }
    }


    /**
     * Move transporter's cargo
     */
    protected void moveLoad() {
        if (loader.getLoad() != null) {
            for (AbstractCar ac : loader.getLoad()) {
                ac.setXPos(this.xPos);
                ac.setYPos(this.yPos);
            }
        }
    }

    /**
     * Move the Vehicle
     * Move all its cargo at the same time
     */
    @Override
    public void move() {
        if (vehicleState.move()) {
            super.move();
            moveLoad();
        }
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

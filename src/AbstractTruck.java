import java.awt.*;

public abstract class AbstractTruck extends AbstractVehicle {

    // todo create loader & move loader code

    /**
     * Min angle of platform
     */
    private final static int MIN_ANGLE = 0;

    /**
     * Max angle of platform
     */
    private final static int MAX_ANGLE = 70;

    /**
     * Angle of the LoadingTruck's platform
     */
    private int platformAngle;

    public AbstractTruck(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int weight) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, weight);
    }

    public AbstractTruck(int xPos, int yPos, int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int weight) {
        super(xPos, yPos, nrDoors, enginePower, currentSpeed, color, modelName, weight);
    }

    /**
     * Set angle of platform
     * Require a minimum and a maximum angle in order to set
     * Also require that the speed of truck is 0
     * @param degree    degree with which to set the platform angle
     */
    protected boolean setAngle(int degree) {
        if (this.getCurrentSpeed() == 0 && (platformAngle >= MIN_ANGLE && platformAngle <= MAX_ANGLE)) {
            platformAngle = degree;
            return true;
        }
        return false;
    }

    /**
     * Get current angle of platform
     * @return angle
     */
    public int getAngle() {
        return platformAngle;
    }

    /**
     * Increment speed
     * Require that the truck platform is down in order to increment speed
     * @param amount The amount with which to increment
     */
    @Override
    protected void incrementSpeed(double amount){
        if (platformAngle == 0)
            super.incrementSpeed(amount);
        else
            System.out.println("Can't move unless platform angle is 0");
    }

    /**
     * Loads the given Vehicle if the Vehicle is close enough, the platform is lowered and if it's not a truck.
     * Distance is set by LOADING_DISTANCE
     * @param t Transportable to be loaded
     */
    @Override
    public boolean load(AbstractVehicle c){
        if (transportNotFull() && isCloseEnoughToLoad(c) && getAngle() == 0) {
            load.add(c);
            return true;
        }
        return false;
    }

    /**
     * Unload the vehicles currently in truck cargo
     * @param vehiclesToUnload number of vehicles to unload
     */
    @Override
    public Transportable unload(int vehiclesToUnload) {
        double loaderXPos = this.getXPos();
        double loaderYPos = this.getYPos();

        for (int i = vehiclesToUnload; i > 0; i--) {
            if (!load.isEmpty()) {
                Car c = load.removeLast();
                c.setXPos(loaderXPos + i);
                c.setYPos(loaderYPos);
                c.setDirection(direction);
            }
        }
    }
}

import java.awt.*;
import java.util.ArrayDeque;

public abstract class Truck extends Carrier {
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

    /**
     * Default constructor
     * @param nrDoors           Doors
     * @param enginePower       Engine power
     * @param currentSpeed      Current speed
     * @param color             Color
     * @param modelName         Model name
     * @param weight            Weight
     * @param maxCars           Maximum amount of cars that fit on the transport
     */
    public Truck(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int weight, int maxCars) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, weight, maxCars, new ArrayDeque<>());
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
     * @param car Car to be loaded
     */
    @Override
    public boolean loadCar(Car car){
        if (transportNotFull() && isCloseEnoughToLoad(car) && getAngle() == 0) {
            load.add(car);
            return true;
        }
        return false;
    }

    /**
     * Unload the vehicles currently in truck cargo
     * @param vehiclesToUnload number of vehicles to unload
     */
    @Override
    public void unloadVehicles(int vehiclesToUnload) {
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

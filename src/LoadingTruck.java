import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

public abstract class LoadingTruck extends Loader {
    /**
     * Min angle of platform
     */
    private final static int MIN_ANGLE = 0;

    /**
     * Max angle of platform
     */
    private final static int MAX_ANGLE = 70;

    /**
     * Current load of transport vehicle
     */
    private Deque<Vehicle> load = new ArrayDeque<>();

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
     */
    public LoadingTruck(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int weight) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, weight);
    }

    /**
     * Set angle of platform
     * Require a minimum and a maximum angle in order to set
     * Also require that the speed of truck is 0
     * @param truck     truck
     * @param degree    degree with which to set the platform angle
     */
    protected boolean setAngle(LoadingTruck truck, int degree) {
        if (truck.getCurrentSpeed() == 0 && (platformAngle >= MIN_ANGLE && platformAngle <= MAX_ANGLE)) {
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
     * @param car Vehicle to be loaded
     */
    @Override
    public void loadCar(Car car){
        boolean isCloseX = this.xPos < car.getXPos() + LOADING_DISTANCE && this.xPos > car.getXPos() - LOADING_DISTANCE;
        boolean isCloseY = this.xPos < car.getXPos() + LOADING_DISTANCE && this.xPos > car.getXPos() - LOADING_DISTANCE;

        if(isCloseX && isCloseY && platformAngle == 0){
            load.push(car);
        }
    }

    /**
     * Unload the vehicles currently in truck cargo
     * @param vehiclesToUnload number of vehicles to unload
     */
    private void unloadVehicles(int vehiclesToUnload) {
        double loaderXPos = this.getXPos();
        double loaderYPos = this.getYPos();

        for (int i = 0; i < vehiclesToUnload; i++) {
            if (!load.isEmpty()) {
                Vehicle v = load.pop();
                v.setXPos(loaderXPos);
                v.setYPos(loaderYPos - 1 - i);
                v.setDirection(direction);
            }
        }
    }

    /**
     * Transfer the coordinates of the truck to the load.
     */
    protected void moveLoad() {
        for (Vehicle v : load) {
            v.setXPos(this.xPos);
            v.setYPos(this.yPos);
        }
    }


}

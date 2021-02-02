import java.awt.*;
import java.util.Stack;

public abstract class LoadingTruck extends Vehicle {
    private static int MIN_ANGLE = 0;
    private static int MAX_ANGLE = 70;
    private static double LOADING_DISTANCE = 20;
    private Stack<Vehicle> load = new Stack<>(); // TODO change to collection, que or whatever
    //private boolean isTruck = LoadingTruck.class.isAss

    public LoadingTruck(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName) {
        super(nrDoors, enginePower, currentSpeed, color, modelName);
    }

    private int platformAngle;

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
     * Set speed factor depending on properties of car
     * @return speed factor (double)
     */
    @Override
    public double speedFactor(){
        return enginePower * 0.01;
    }
    /**
     * Loads the given car if the car is close enough, the platform is lowered and if its not a truck.
     * Distance is set by LOADING_DISTANCE
     * @param car car to be loaded
     */
    public void loadCar(Vehicle car){
        // TODO make it more general... with object as parameter? (Same for moveLoad)
        // TODO limit of load?
        boolean isCloseX = this.xPos < car.getXPos() + LOADING_DISTANCE && this.xPos > car.getXPos() - LOADING_DISTANCE;
        boolean isCloseY = this.xPos < car.getXPos() + LOADING_DISTANCE && this.xPos > car.getXPos() - LOADING_DISTANCE;

        if(isCloseX && isCloseY && platformAngle == 0 && !((Vehicle)car instanceof LoadingTruck)){ // cast for future
            load.push(car);
        }
    }

    /**
     * Transfer the coordinates of the truck to the load.
     * NEEDS TO BE UPDATED WITH THE MOVE FUNCTION // TODO fix? Other ideas? oRKa
     */

    private void moveLoad(){
        for (Vehicle v:load
             ) {
            v.setXPos(this.xPos);
            v.setYPos(this.yPos);
        }
    }


}

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Ferry class
 * Takes Cars as cargo
 */
public class Ferry extends Loader {

    Queue<Car> load = new LinkedList<>();

    public Ferry(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int weight) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, weight, 50);
    }

    /**
     * Check if loading is possible (e.g. not exceeding maximum amount of cars already in transport)
     */
    @Override
    protected boolean checkIfLoadPossible() {
        return load.size() < MAX_CARS;
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
        if(isCloseX && isCloseY){
            load.add(car);
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
            Car c = load.remove();
            c.direction[0] = loaderXPos;
            c.direction[1] = loaderYPos + 1 + i;
        }
    }

    /**
     * Move load using Queue
     */
    @Override
    protected void moveLoad() {
        for (Car c : load) {
            c.setXPos(this.xPos);
            c.setYPos(this.yPos);
        }
    }
}

import java.awt.*;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Ferry class
 * Takes Cars as cargo
 */
public class Ferry extends Carrier {

    /**
     * Ferry's cargo
     */
    Deque<Car> load;

    public Ferry(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int weight) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, weight, 50, new LinkedList<>());
    }

    /**
     * Loads the given Car if it's in proximity and if the transport isn't full
     * Distance is set by LOADING_DISTANCE
     * @param car Car to be loaded
     */
    @Override
    public void loadCar(Car car){
        if (transportNotFull() && isCloseEnoughToLoad(car))
            load.add(car);
    }

    /**
     * Unload the cars currently in truck cargo
     * @param carsToUnload number of vehicles to unload
     */
    private void unloadVehicles(int carsToUnload) {
        double loaderXPos = this.getXPos();
        double loaderYPos = this.getYPos();

        for (int i = 0; i < carsToUnload; i++) {
            Car c = load.removeFirst();
            c.direction[0] = loaderXPos;
            c.direction[1] = loaderYPos + 1 + carsToUnload - i;
        }
    }
}

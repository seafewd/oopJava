import java.util.ArrayList;

/**
 * Workshop super class
 */
public class Workshop<T> {

    /**
     * Max number of cars
     */
    private final int maxCars;

    /**
     * For storing the cars
     */
    ArrayList<T> cars = new ArrayList();

    /**
     * Workshop that can load/fix cars (or other objects). It depends on what type it is takes.
     * @param maxCars
     */
    Workshop(int maxCars){
        this.maxCars = maxCars;
    }

    /**
     * Leave car (store the car in the list)
     * @param object the car (with the type T) in this case
     * @return true if car was successfully stored
     */
    protected boolean leaveCar(T object) {
        if (cars.size() > maxCars)
            return false;
        return cars.add(object);
    }
}

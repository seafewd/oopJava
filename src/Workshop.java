import java.util.ArrayList;
import java.util.List;

/**
 * Workshop super class
 */
public class Workshop<T> {

    /**
     * Max number of cars
     */
    private final int MAX_CARS;

    /**
     * For storing the cars
     */
    List<T> cars = new ArrayList<>();

    /**
     * Workshop that can load/fix cars (or other objects). It depends on what type it takes.
     * @param MAX_CARS      Max cars to hold
     */
    Workshop(int MAX_CARS){
        this.MAX_CARS = MAX_CARS;
    }

    /**
     * Leave car (store the car in the list)
     * @param object the car in this case
     * @return true if car was successfully stored
     */
    protected boolean storeCar(T object) {
        if (cars.size() > MAX_CARS)
            return false;
        return cars.add(object);
    }
}

import java.util.ArrayList;
import java.util.List;

/**
 * General workshop. Accepts all types of cars
 */
public class GeneralWorkshop extends Workshop{

    /**
     * List of cars currently in workshop
     */
    private List<Car> cars;

    /**
     * Default constructor
     */
    public GeneralWorkshop(int maxCars){
        super(maxCars);
        cars = new ArrayList<>();
    }

    protected boolean leaveCar(Car car) {
        if (cars.size() > MAX_CARS)
            return false;
        return cars.add(car);
    }
}

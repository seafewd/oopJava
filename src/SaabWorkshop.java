import java.util.ArrayList;
import java.util.List;

/**
 * Saab workshop. Only accepts Saab cars
 */
public class SaabWorkshop extends Workshop{
    private List<Saab95> cars;

    public SaabWorkshop(int maxCars){
        super(maxCars);
        cars = new ArrayList<>();
    }


    protected boolean leaveCar(Saab95 saab) {
        if (cars.size() > MAX_CARS)
            return false;
        return cars.add((Saab95) saab);
    }
}

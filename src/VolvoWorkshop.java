import java.util.ArrayList;
import java.util.List;

/**
 * Saab workshop. Only accepts Saab cars
 */
public class VolvoWorkshop extends Workshop{
    private List<Volvo240> cars;

    public VolvoWorkshop(int maxCars){
        super(maxCars);
        cars = new ArrayList<>();
    }

    @Override
    protected boolean leaveCar(Car volvo) {
        if (cars.size() > MAX_CARS)
            return false;
        return cars.add((Volvo240) volvo);
    }
}

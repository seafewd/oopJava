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
    protected boolean leaveCar(Volvo240 volvo) {
        if (cars.size() > MAX_CARS)
            return false;
        return cars.add(volvo);
    }
}

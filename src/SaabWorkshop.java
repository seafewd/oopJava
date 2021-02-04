import java.util.ArrayList;
import java.util.List;

/**
 * Saab workshop. Only accepts Saab cars
 */
public class SaabWorkshop extends Workshop{
    private List<Saab95> cars;

    public SaabWorkshop(){
        super(10);
        cars = new ArrayList<>();
    }

    @Override
    protected boolean leaveCar(Saab95 saab) {
        if (cars.size() > MAX_CARS)
            return false;
        return cars.add(saab);
    }
}

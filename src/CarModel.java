import java.util.ArrayList;
import java.util.List;

public class CarModel {
    private final int CAR_WIDTH = 46;

    // List of cars
    private List<AbstractVehicle> vehicles = new ArrayList<>();

    private VehicleFactory vehicleFactory;

    public CarModel() {

        this.vehicleFactory = new VehicleFactory(this);
    }

    public int getCAR_WIDTH() {
        return CAR_WIDTH;
    }

    public void update(){
        for (AbstractVehicle vehicle : vehicles
             ) {
            vehicle.move();
        }
    }

    public List<AbstractVehicle> getVehicles() {
        return vehicles;
    }

    public VehicleFactory getVehicleFactory() {
        return vehicleFactory;
    }
}

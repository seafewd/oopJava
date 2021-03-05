import java.util.ArrayList;
import java.util.List;

public class CarModel {
    private final int CAR_WIDTH = 46;

    // List of cars
    private List<AbstractVehicle> vehicles = new ArrayList<>();

    private VehicleFactory vehicleFactory;

    public CarModel() {

        this.vehicleFactory = new VehicleFactory(this);
        // create vehicles
        this.getVehicles().add(getVehicleFactory().createVehicle("Volvo", 0, 0));
        this.getVehicles().add(getVehicleFactory().createVehicle("Saab", 0, 100));
        this.getVehicles().add(getVehicleFactory().createVehicle("Scania", 0,200));
    }

    public int getCAR_WIDTH() {
        return CAR_WIDTH;
    }

    public List<AbstractVehicle> getVehicles() {
        return vehicles;
    }

    public VehicleFactory getVehicleFactory() {
        return vehicleFactory;
    }
}

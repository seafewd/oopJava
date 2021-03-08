import java.util.ArrayList;
import java.util.List;

public class CarModel implements ISubject {

    private ArrayList<IObserver> observers;

    private final int CAR_WIDTH = 78;

    // List of cars
    private List<AbstractVehicle> vehicles;

    private final VehicleFactory vehicleFactory;

    public CarModel() {
        this.vehicleFactory = new VehicleFactory(this);
        this.vehicles = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public int getCAR_WIDTH() {
        return CAR_WIDTH;
    }

    public void update(){
        for (AbstractVehicle vehicle : vehicles)
            vehicle.move();
    }

    public List<AbstractVehicle> getVehicles() {
        return vehicles;
    }

    public VehicleFactory getVehicleFactory() {
        return vehicleFactory;
    }

    /**
     * Only checks X-axis
     * @param
     * @return
     */
    public void checkIfOutOfBounds(int frameWidth){
        for(AbstractVehicle av : getVehicles())
            if (av.getXPos() + CAR_WIDTH > (frameWidth - CAR_WIDTH/2) || av.getXPos() < 0)
                av.setDirection(new double[]{av.getDirection()[0] * -1, 0});
    }

    @Override
    public void register(IObserver observer) {
        this.observers.add(observer);
        System.out.println("observer registered");

    }

    @Override
    public void unregister(IObserver observer) {
        this.observers.remove(observers.indexOf(observer));
        System.out.println("observer unregistered");
    }

    @Override
    public void notifyObservers() {
        for (IObserver observer : observers) {
            observer.update();
        }
        System.out.println("observers notified");
    }
}

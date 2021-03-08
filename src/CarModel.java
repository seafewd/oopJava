import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CarModel implements IObservable {

    private ArrayList<IObserver> observers;

    private final int CAR_WIDTH = 78;

    // List of cars
    private List<AbstractVehicle> vehicles;

    private final VehicleFactory vehicleFactory;

    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 10;
    private Timer timer = new Timer(delay, new TimerListener());

    public CarModel() {
        this.vehicleFactory = new VehicleFactory(this);
        this.vehicles = new ArrayList<>();
        this.observers = new ArrayList<>();
        timer.start();
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

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            update();
        }
    }

    public void update(){
        for (AbstractVehicle vehicle : vehicles)
            vehicle.move();
        for (IObserver observer : observers) {
            ((CarView) observer).repaint();
            checkIfOutOfBounds(1200);
        }
    }

}

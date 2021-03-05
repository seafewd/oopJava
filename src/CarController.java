import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {

    // View, Model and Vehicle Factory
    CarModel model;
    VehicleFactory vFactory;
    List<AbstractVehicle> vehicles;

    public final int VEHICLE_SPACING = 65;


    public CarController(CarModel model){
        this.model = model;
        vehicles = model.getVehicles();
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (AbstractVehicle abstractVehicle : model.getVehicles()) {
            abstractVehicle.gas(gas);
        }
    }

    void setTurboOn(){
        for (AbstractVehicle av : model.getVehicles()) {
            ((Saab95) av).toggleTurbo();
        }
    }

    void setTurboOff(){
        for (AbstractVehicle av : model.getVehicles()) {
            ((Saab95) av).toggleTurbo();
        }
    }

    // brake car
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (AbstractVehicle abstractVehicle : model.getVehicles()) {
            abstractVehicle.brake(brake);
        }
    }

    void flipXDirection(AbstractVehicle v) {
        double[] currentDirection = v.getDirection();
        v.setDirection(new double[]{currentDirection[0] * -1, currentDirection[1]});
    }

    void flipYDirection(AbstractVehicle v) {
        double[] currentDirection = v.getDirection();
        v.setDirection(new double[]{currentDirection[0], currentDirection[1] * -1});
    }

    void stopAllCars() {
        for (AbstractVehicle v : model.getVehicles()) {
            v.setCurrentSpeed(0);
        }
    }

    void startAllCars(int amount) {
        for (AbstractVehicle v : model.getVehicles()) {
            if (v.getCurrentSpeed() == 0)
                v.setCurrentSpeed(((double) amount) / 100);
        }
    }

    /**
     * Set turbo on or off
     */
    void toggleTurbo() {
        List<Saab95> saabs = new ArrayList<>();
        for (AbstractVehicle v : model.getVehicles()) {
            if (v instanceof Saab95) {
                saabs.add((Saab95) v);
            }
        }
        for (Saab95 s : saabs) {
            s.toggleTurbo();
        }
    }


    /**
     * Flip truck platform up or down
     */
    void setPlatformAngle(int angle) {
        //hardcoded because gui reasons...
        List<AbstractTruck> abstractTrucks = new ArrayList<>();
        for (AbstractVehicle v : model.getVehicles())
            if (v instanceof AbstractTruck)
                abstractTrucks.add((AbstractTruck) v);

        for (AbstractTruck abstractTruck : abstractTrucks)
            abstractTruck.getRamp().setAngle(angle);
    }

    public AbstractVehicle addVehicle(String option) {
        AbstractVehicle av;
        List<AbstractVehicle> vs = model.getVehicles();
        int lastVehicleYPosition;
        if (!vs.isEmpty())
            lastVehicleYPosition = vs.get(vs.size()-1).getYPos() + VEHICLE_SPACING;
        else
            lastVehicleYPosition = 0;
        switch (option) {
            case "Volvo 240" -> av = model.getVehicleFactory().createVehicle("Volvo", 0, lastVehicleYPosition);
            case "Saab 95" -> av = model.getVehicleFactory().createVehicle("Saab", 0, lastVehicleYPosition);
            case "Scania" -> av = model.getVehicleFactory().createVehicle("Scania", 0, lastVehicleYPosition);
            case "Volvo Truck" -> av = model.getVehicleFactory().createVehicle("VolvoTruck", 0, lastVehicleYPosition);
            case "Random vehicle" -> av = model.getVehicleFactory().createVehicle("Volvo", 0, lastVehicleYPosition);
            default -> throw new IllegalArgumentException("Couldn't create car!");
        }
        return av;
    }

    public boolean removeVehicle(AbstractVehicle av) {
        return model.getVehicles().remove(av);
    }

    public boolean vehicleListFull() {
        return model.getVehicles().size() >= model.getVehicleFactory().MAX_CARS;
    }

    public boolean vehicleListEmpty() {
        return model.getVehicles().isEmpty();
    }
}

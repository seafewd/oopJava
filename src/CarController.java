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

    // member fields:



    // View, Model and Vehicle Factory
    CarModel model;
    VehicleFactory vFactory;
    List<AbstractVehicle> vehicles;


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

    /**
     * Only checks X-axis
     * @param
     * @return
     */
    // TODO: Add y

    /*
    private boolean isOutOfBounds(AbstractVehicle abstractVehicle){
        return abstractVehicle.getXPos() + model.getCAR_WIDTH() > frame.getWidth() || abstractVehicle.getXPos() < 0;
    }

     */

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
}

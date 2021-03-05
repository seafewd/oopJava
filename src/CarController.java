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

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 10;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // View, Model and Vehicle Factory
    CarView frame;
    CarModel model;
    VehicleFactory vFactory;

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);
        cc.model = new CarModel();

        for (AbstractVehicle v:cc.model.getVehicles())
            System.out.println(v.getYPos());

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (AbstractVehicle vehicle : model.getVehicles()) {
                vehicle.move();
                if(isOutOfBounds(vehicle))
                    flipXDirection(vehicle);
                int x = (int) Math.round(vehicle.getXPos());
                int y = (int) Math.round(vehicle.getYPos());
                frame.drawPanel.moveit(x, y, vehicle);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
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
     * @param abstractVehicle
     * @return
     */
    // TODO: Add y
    private boolean isOutOfBounds(AbstractVehicle abstractVehicle){
        return abstractVehicle.getXPos() + model.getCAR_WIDTH() > frame.getWidth() || abstractVehicle.getXPos() < 0;
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
        switch (option) {
            case "Volvo 240" -> av = model.getVehicleFactory().createVehicle("Volvo");
            case "Saab 95" -> av = model.getVehicleFactory().createVehicle("Saab");
            case "Scania" -> av = model.getVehicleFactory().createVehicle("Scania");
            case "Volvo Truck" -> av = model.getVehicleFactory().createVehicle("VolvoTruck");
            case "Random vehicle" -> av = model.getVehicleFactory().createVehicle("Volvo");
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
}

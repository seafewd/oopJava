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

    private final int CAR_WIDTH = 46;
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 10;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    List<Vehicle> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240(0,0));
        cc.cars.add(new Saab95(0, 100));
        cc.cars.add(new Scania(0,200));

        for (Vehicle v:cc.cars)
            System.out.println(v.getYPos());

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : cars) {
                vehicle.move();
                if(isOutOfBounds(vehicle))
                    flipXDirection(vehicle);
                int x = (int) Math.round(vehicle.getXPos());
                int y = (int) Math.round(vehicle.getYPos());
                frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : cars) {
            vehicle.gas(gas);
        }
    }

    void setTurboOn(){
        for (Vehicle vehicle : cars) {
            if(vehicle instanceof Saab95)
                ((Saab95) vehicle).setTurboOn();
        }
    }

    void setTurboOff(){
        for (Vehicle vehicle : cars) {
            if(vehicle instanceof Saab95)
                ((Saab95) vehicle).setTurboOff();
        }
    }

    /**
     * Only checks X-axis
     * @param vehicle
     * @return
     */
    // TODO: Add y
    private boolean isOutOfBounds(Vehicle vehicle){
        return vehicle.getXPos() + CAR_WIDTH > frame.getWidth() || vehicle.getXPos() < 0;
    }

    // brake car
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : cars) {
            vehicle.brake(brake);
        }
    }

    void flipXDirection(Vehicle v) {
        double[] currentDirection = v.getDirection();
        v.setDirection(new double[]{currentDirection[0] * -1, currentDirection[1]});
    }

    void flipYDirection(Vehicle v) {
        double[] currentDirection = v.getDirection();
        v.setDirection(new double[]{currentDirection[0], currentDirection[1] * -1});
    }

    void stopAllCars() {
        for (Vehicle v : cars) {
            v.setCurrentSpeed(0);
        }
    }

    void startAllCars(int amount) {
        for (Vehicle v : cars) {
            if (v.getCurrentSpeed() == 0)
                v.setCurrentSpeed(((double) amount) / 100);
        }
    }

    /**
     * Set turbo on or off
     * @param state false for off, true for on
     */
    void setTurboState(boolean state) {
        List<Saab95> saabs = new ArrayList<>();
        for (Vehicle v : cars) {
            if (v instanceof Saab95) {
                saabs.add((Saab95) v);
            }
        }
        for (Saab95 s : saabs) {
            if (state)
                s.setTurboOn();
            else
                s.setTurboOff();
        }
    }

    /**
     * Flip truck platform up or down
     */
    void setPlatformAngle(int angle) {
        //hardcoded because gui reasons...
        List<Truck> trucks = new ArrayList<>();
        for (Vehicle v : cars)
            if (v instanceof Truck)
                trucks.add((Truck) v);

        for (Truck truck : trucks)
            truck.setAngle(angle);
    }
}

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

    private final int CAR_WIDTH = 20;
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 10;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        //cc.cars.add(new Volvo240(0,0));
        cc.cars.add(new Saab95(0, 10));
        //cc.cars.add(new Scania(0,20));

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

    /**
     * Call gas method for each vehicle once
     * @param amount amount to gas
     */
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : cars) {
            vehicle.gas(gas);
        }
    }

    /**
     * Check if vehicle is out of x-axis bounds
     * @param vehicle vehicle
     * @return is out of bounds
     * todo add y bounds
     */
    private boolean isOutOfBounds(Vehicle vehicle){
        return vehicle.getXPos() + CAR_WIDTH > frame.getWidth() || vehicle.getXPos() < 0;
    }

    /**
     * Brake vehicle
     * @param amount brake amount
     */
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : cars) {
            vehicle.brake(brake);
        }
    }

    /**
     * Flip x direction of vehicle
     * @param v direction
     */
    void flipXDirection(Vehicle v) {
        double[] currentDirection = v.getDirection();
        v.setDirection(new double[]{currentDirection[0] * -1, currentDirection[1]});
    }

    /**
     * Flip y direction of vehicle
     * @param v vehicle
     */
    void flipYDirection(Vehicle v) {
        double[] currentDirection = v.getDirection();
        v.setDirection(new double[]{currentDirection[0], currentDirection[1] * -1});
    }

    /**
     * Stop all vehicles
     */
    void stopAllCars() {
        for (Vehicle v : cars) {
            v.setCurrentSpeed(0);
        }
    }

    /**
     * Start all vehicles with speed parameter
     * @param amount speed
     */
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
}

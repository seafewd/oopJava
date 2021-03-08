import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.GapContent;
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

    private final int GAS_AMOUNT = 100;
    private final int BRAKE_AMOUNT = 100;

    // View, Model and Vehicle Factory
    CarModel model;
    CarView view;
    List<AbstractVehicle> vehicles;


    public final int VEHICLE_SPACING = 65;


    public CarController(CarModel model, CarView view){
        this.model = model;
        this.view = view;
        vehicles = model.getVehicles();

        view.addGasButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gas(GAS_AMOUNT);
            }
        });

        view.addBrakeButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                brake(BRAKE_AMOUNT);
            }
        });

        view.addStartButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startAllCars(GAS_AMOUNT);
            }
        });

        view.addStopButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopAllCars();
            }
        });

        view.addTurboOnButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleTurbo();
            }
        });

        view.addTurboOffButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleTurbo();
            }
        });

        view.addLiftBedButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setPlatformAngle(0);
            }
        });

        view.addLowerBedButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setPlatformAngle(70);
            }
        });

        view.addAddCarButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // check if able to add cars
                if (vehicleListFull()) {
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame,"The vehicle list is full.\nYou can only have up to 10 vehicles.");
                    return;
                }

                String[] options = {"Volvo 240", "Saab 95", "Scania", "Volvo Truck", "Random vehicle"};
                /* Scuffed...
                Map<String, Integer> map = new HashMap<>();
                map.put("Volvo 240", 0);
                map.put("Saab 95", 1);
                map.put("Scania", 2);
                map.put("Volvo Truck", 3);
                */
                String result = (String) JOptionPane.showInputDialog(
                        view.getDrawPanel(),
                        "Which vehicle would you like to add?",
                        "Add vehicle",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,    // options array
                        options[0]                  // initial state
                );
                addVehicle(result);
            }
        });

        view.addRemoveCarButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<AbstractVehicle> cars = model.getVehicles();
                if (!vehicleListEmpty())
                    removeVehicle(cars.get(cars.size()-1));
            }
        });
}


    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (AbstractVehicle abstractVehicle : model.getVehicles()) {
            abstractVehicle.gas(gas);
        }
    }

    // brake car
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (AbstractVehicle abstractVehicle : model.getVehicles()) {
            abstractVehicle.brake(brake);
        }
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
            abstractTruck.setRampAngle(angle);
    }

    public AbstractVehicle addVehicle(String option) {
        AbstractVehicle av;
        List<AbstractVehicle> vs = model.getVehicles();
        int lastVehicleYPosition;
        if (!vs.isEmpty())
            lastVehicleYPosition = vs.get(vs.size()-1).getYPos() + VEHICLE_SPACING;
        else
            lastVehicleYPosition = 0;
        av = model.getVehicleFactory().createVehicle(option, 0, lastVehicleYPosition);
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

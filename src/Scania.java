import java.awt.*;

/**
 * A type of MotorVehicle
 * Extends Vehicle which implements Movable
 */
public class ScaniaTruck extends MotorVehicle {

    private class Flatbed {
        
    }

    /**
     * Default constructor
     * @param nrDoors
     * @param enginePower
     * @param currentSpeed
     * @param color
     * @param modelName
     */
    public ScaniaTruck(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName) {
        super(nrDoors, enginePower, currentSpeed, color, modelName);
    }

    @Override
    protected double speedFactor() {
        return enginePower * 0.01;
    }
}

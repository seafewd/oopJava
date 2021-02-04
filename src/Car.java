import java.awt.*;

public abstract class Car extends Vehicle{
    /**
     * Default constructor
     *
     * @param nrDoors      no. of doors
     * @param enginePower  engine power
     * @param currentSpeed current speed
     * @param color        color
     * @param modelName    model name
     * @param weight
     */
    public Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int weight) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, weight);
    }
}

import java.awt.*;

public class AbstractCar extends AbstractVehicle {

    public AbstractCar(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int weight) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, weight);
    }

    public AbstractCar(int xPos, int yPos, int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int weight) {
        super(xPos, yPos, nrDoors, enginePower, currentSpeed, color, modelName, weight);
    }
}

import java.awt.*;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Ferry class
 * Takes Cars as cargo
 */
public abstract class AbstractFerry extends AbstractVehicle {

    private final int loadingDistance;

    public AbstractFerry(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int weight, int loadingDistance) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, weight);
        this.loadingDistance = loadingDistance;
    }

    public AbstractFerry(int xPos, int yPos, int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int weight, int loadingDistance) {
        super(xPos, yPos, nrDoors, enginePower, currentSpeed, color, modelName, weight);
        this.loadingDistance = loadingDistance;
    }

}

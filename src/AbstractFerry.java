import java.awt.*;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Ferry class
 * Takes Cars as cargo
 */
public abstract class AbstractFerry extends AbstractVehicle {


    /**
     * Loader attached to Truck
     */
    private final Loader<AbstractVehicle> loader;


    public AbstractFerry(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int weight, int loadingDistance) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, weight);
        this.loader = new Loader<>(loadingDistance);
    }

    public AbstractFerry(int xPos, int yPos, int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int weight, int loadingDistance) {
        super(xPos, yPos, nrDoors, enginePower, currentSpeed, color, modelName, weight);
        this.loader = new Loader<>(loadingDistance);
    }

    /**
     * Check if car is close enough to the transport to be able to be loaded onto it
     * @param av    AbstractCar to check
     * @return      Proximity check
     */
    public boolean isCloseEnoughToLoad(AbstractVehicle av) {
        boolean isCloseX = this.xPos < av.getXPos() + loader.getLoadingDistance() && this.xPos > av.getXPos() - loader.getLoadingDistance();
        boolean isCloseY = this.yPos < av.getYPos() + loader.getLoadingDistance() && this.yPos > av.getYPos() - loader.getLoadingDistance();
        return isCloseX && isCloseY;
    }

}

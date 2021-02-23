import java.awt.*;

/**
 * A type of Vehicle
 * Extends Vehicle which implements Movable
 */
public class VolvoTruck extends AbstractTruck {

    /**
     * Default constructor
     */
    public VolvoTruck() {
        super(2, 300, 0, Color.BLACK, "Volvo Truckerino", 6250);
    }

    /**
     * Constructor with position
     * @param xPos  xpos
     * @param yPos  ypos
     */
    public VolvoTruck(int xPos, int yPos) {
        super(xPos, yPos, 2, 300, 0, Color.BLACK, "Volvo Truckerino", 6250);
    }
}

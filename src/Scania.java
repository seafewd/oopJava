import java.awt.*;

/**
 * A type of Vehicle
 * Extends Vehicle which implements Movable
 */
public class Scania extends AbstractTruck {


    /**
     * Default constructor
     */
    public Scania() {
        super(2, 120, 0, Color.WHITE, "Scania", 3900, 2);
    }

    /**
     * Constructor with position
     * @param xPos  xpos
     * @param yPos  ypos
     */
    public Scania(int xPos, int yPos) {
        super(xPos, yPos,2, 300, 0, Color.WHITE, "Scania", 3900, 2);
    }

}

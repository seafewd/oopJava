import java.awt.*;

/**
 * A type of Vehicle
 * Extends Vehicle which implements Movable
 */
public class Scania extends Loader<Transportable> implements Transporter<Transportable> {

    private final Loader<Car> dt;

    /**
     * Default constructor
     */
    public Scania() {
        dt = new Loader<>(2, 300, 0, Color.WHITE, "Scania", 3900, 5);
    }

    public Scania(double xPos, double yPos) {
        dt = new Loader<Car>(xPos, yPos,2, 300, 0, Color.WHITE, "Scania", 3900, 5);
    }

    @Override
    public boolean load(Transportable t) {
        return dt.load(t);
    }

    @Override
    public Transportable unload(int numberToUnload) {
        return dt.unload(numberToUnload);
    }
}

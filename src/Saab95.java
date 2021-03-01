import java.awt.*;

/**
 * A type of Vehicle
 * Extends Vehicle which implements Movable
 */

public class Saab95 extends AbstractVehicle implements Car, Transportable {
    private final Turbo turbo;

    /**
     * Default constructor
     */
    public Saab95(){
        super(2, 125, 0, Color.red, "Saab95", 2300);
        this.turbo = new Turbo();
    }

    /**
     * Constructor with position
     * @param xPos xpos
     * @param yPos ypos
     */
    public Saab95(int xPos, int yPos){
        super(xPos, yPos, 2, 125, 0, Color.red, "Saab95", 2300);
        this.turbo = new Turbo();
    }

    /**
     * Set speed factor
     * @return speed factor
     */
    @Override
    public double speedFactor(){
        double power;
        if(turbo.isTurboOn())
            power = 1.3;
        else
            power = 1;
        return movePower * 0.01 * power;
    }

    public void toggleTurbo() {
        turbo.toggleTurboOn();
    }

    public Turbo getTurbo() {
        return turbo;
    }
}

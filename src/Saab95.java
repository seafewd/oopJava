import java.awt.*;

/**
 * A type of car
 * Extends Car which implements Movable
 */
public class Saab95 extends Car {
    private boolean turboOn;

    /**
     * Default constructor
     */
    public Saab95(){
        super(2, 125, 0, Color.red, "Saab95");
	    turboOn = false;
    }

    /**
     * Set turbo on
     */
    public void setTurboOn(){
	    turboOn = true;
    }

    /**
     * Set turbo off
     */
    public void setTurboOff(){
	    turboOn = false;
    }

    /**
     * Set speed factor
     * @return speed factor
     */
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
}

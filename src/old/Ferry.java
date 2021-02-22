package old;

import java.awt.*;
import java.util.Deque;
import java.util.LinkedList;

/**
 * old.Ferry class
 * Takes Cars as cargo
 */
public abstract class Ferry extends Vehicle implements Transporter {

    public Ferry(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int weight) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, weight, 50);
    }

}

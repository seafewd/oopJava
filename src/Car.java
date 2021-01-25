import java.awt.*;

/**
 * Parent class, handles all types of cars
 * Implements Movable for movement and position related issues
 */
public class Car implements Movable {

    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name


    /**
     * Get number of doors
     * @return Number of doors
     */
    protected int getNrDoors(){
        return nrDoors;
    }

    /**
     * Get engine power of car
     * @return Engine power
     */
    protected double getEnginePower(){
        return enginePower;
    }

    /**
     * Get current speed of car
     * @return Current speed
     */
    protected double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * Get color of car
     * @return Color
     */
    protected Color getColor(){
        return color;
    }

    /**
     * Set the color of the car
     * @param clr Color to set
     */
    protected void setColor(Color clr){
        color = clr;
    }

    /**
     * Start car engine
     */
    protected void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * Stop car engine
     */
    protected void stopEngine(){
        currentSpeed = 0;
    }


    /**
     * Move the car
     */
    @Override
    public void move() {

    }

    /**
     * Make car turn left
     */
    @Override
    public void turnLeft() {

    }

    /**
     * Make car turn right
     */
    @Override
    public void turnRight() {

    }
}

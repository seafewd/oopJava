/**
 * Interface Movable
 * Implemented by Vehicle
 * Prototypes movement and position of an object
 */
public interface Movable {

    /**
     * Get X pos
     * @return xPos
     */
    double getXPos();

    /**
     * Get Y pos
     * @return yPos
     */
    double getYPos();

    /**
     * Set X pos
     */
    void setXPos(double xPos);

    /**
     * Set X pos
     */
    void setYPos(double yPos);

    /**
     * Move object
     */
    void move();

    /**
     * Turn left
     */
    void turnLeft();

    /**
     * Turn right
     */
    void turnRight();
}

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
    int getXPos();

    /**
     * Get Y pos
     * @return yPos
     */
    int getYPos();

    /**
     * Set X pos
     */
    void setXPos(int xPos);

    /**
     * Set X pos
     */
    void setYPos(int yPos);

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

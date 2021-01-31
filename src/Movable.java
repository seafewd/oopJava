/**
 * Interface Movable
 * Implemented by Car
 * Prototypes movement of an object
 */
public interface Movable {

    /**
     * Move object
     */
    void move();

    /**
     * Turn left
     */
    void turnLeft(double radians);

    /**
     * Turn right
     */
    void turnRight(double radians);
}

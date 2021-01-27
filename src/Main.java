import org.junit.jupiter.api.Test;

/**
 * Program entry point
 */
public class Main {
    /**
     * Our main method
     * @param args None defined
     */
    public static void main(String[] args) {
        Car volvo = new Volvo240();
        System.out.println("Created a " + volvo.modelName);
        volvo.startEngine();
        volvo.move();
        volvo.move();
        volvo.turnLeft();
        volvo.move();
        volvo.turnRight();
        volvo.move();

    }
}

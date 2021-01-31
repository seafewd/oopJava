
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
        Saab95 saab = new Saab95();
        System.out.println("Created a " + saab.modelName);
        saab.setTurboOff();
        saab.startEngine();
        saab.showDirection();
        saab.move();
        saab.turnLeft(Math.PI/2);
        saab.move();
        saab.showDirection();

        /*
        volvo.move();
        volvo.move();
        volvo.turnLeft(90);
        volvo.move();
        volvo.turnRight(90);
        volvo.move();

         */

    }
}


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
        Vehicle saab = new Saab95();
        System.out.println("Created a " + saab.modelName);
        ((Saab95) saab).setTurboOff();
        saab.startEngine();
        saab.showDirection();
        saab.move();
        saab.turnLeft();
        saab.move();
        saab.showDirection();

        LoadingTruck scania = new Scania();
        LoadingTruck volvoTruck = new VolvoTruck();

        volvoTruck.move();
        volvoTruck.move();
        volvoTruck.turnLeft();
        volvoTruck.move();
        volvoTruck.turnRight();
        volvoTruck.move();
    }
}
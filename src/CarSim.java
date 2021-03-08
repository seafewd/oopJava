/**
 * Program entry point
 */
public class CarSim {
    /**
     * Main method
     * @param args None defined
     */
    public static void main(String[] args) {
        CarController carController = new CarController(new CarModel());
    }
}
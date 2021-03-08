/**
 * Program entry point
 */
public class CarSim {
    /**
     * Main method
     * @param args None defined
     */
    public static void main(String[] args) {
        CarModel model = new CarModel();
        CarView view = new CarView("Totally amazing and fun car simulation", model);
        CarController carController = new CarController(model, view);
    }
}

/**
 * Program entry point
 */
public class Main {
    /**
     * Main method
     * @param args None defined
     */
    public static void main(String[] args) {
        Saab95 saab = new Saab95();
        saab.setTurboOff();
        saab.startEngine();
        saab.showDirection();
        saab.move();
        saab.turnLeft();
        saab.move();
        saab.showDirection();

        Loader scania = new Scania();
        Loader volvoTruck = new VolvoTruck();
        scania.loadCar(saab);
        scania.move();

        volvoTruck.move();
        volvoTruck.move();
        volvoTruck.turnLeft();
        volvoTruck.move();
        volvoTruck.turnRight();
        volvoTruck.move();

        Workshop volvoWorkshop = new VolvoWorkshop(4);
        volvoWorkshop.leaveCar(saab);
    }
}
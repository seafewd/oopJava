/**
 * Program entry point
 */
public class CarSim {
    /**
     * Main method
     * @param args None defined
     */
    public static void main(String[] args) {

        CarModel carModel = new CarModel();
        CarController carController = new CarController(carModel);
        CarView carView = new CarView("Totally amazing and fun car simulation", carController, carModel);


/*
        CarController cc = new CarController();
        CarView view = new CarView("View", cc);


        Saab95 saab = new Saab95();
        saab.setTurboOff();
        saab.startEngine();
        saab.showDirection();
        saab.move();
        saab.turnLeft();
        saab.move();
        saab.showDirection();

        Carrier scania = new Scania();
        Carrier volvoTruck = new VolvoTruck();
        scania.load(saab);
        scania.move();

        volvoTruck.move();
        volvoTruck.move();
        volvoTruck.turnLeft();
        volvoTruck.move();
        volvoTruck.turnRight();
        volvoTruck.move();

        Volvo240 volvo = new Volvo240();
        Workshop<Volvo240> ws = new Workshop(10);

        ws.storeCar(volvo);
        //ws.storeCar(saab.jpg);*/
    }
}
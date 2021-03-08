public class VehicleFactory {
    CarModel model;

    public final int MAX_CARS = 10;

    public VehicleFactory(CarModel model) {
        this.model = model;
    }

    /**
     * Create vehicle wrapper
     * @param v vehicle type
     * @return AbstractVehicle
     */
    public AbstractVehicle createVehicle(String v) {
        AbstractVehicle av = createVehicleWithPosition(v);
        model.getVehicles().add(av);
        return av;
    }

    /**
     * Create vehicle wrapper
     * Handles position
     * @param v vehicle type
     * @return AbstractVehicle
     */
    public AbstractVehicle createVehicle(String v, int xPos, int yPos) {
        AbstractVehicle av = createVehicleWithPosition(v, xPos, yPos);
        model.getVehicles().add(av);
        return av;
    }

    /**
     * Create a vehicle with no position
     * @param v vehicle type
     * @return AbstractVehicle
     */
    public AbstractVehicle createVehicleWithPosition(String v) {
        AbstractVehicle av = null;

        switch (v) {
            case "Saab 95":
                av = new Saab95();
                System.out.println("created a Saab 95");
                break;
            case "Volvo 240":
                av = new Volvo240();
                System.out.println("created a Volvo 240");
                break;
            case "Scania":
                av = new Scania();
                System.out.println("created a Scania");
                break;
            case "Volvo Truck":
                av = new VolvoTruck();
                System.out.println("created a Volvo Truck");
                break;
            case "Ferry":
                av = new BoatyMcBoatFace();
            default:
                System.out.println("Couldn't create vehicle - bad parameter");
                break;
        }
        return av;
    }

    /**
     * Create a vehicle with position
     * @param v vehicle type
     * @return AbstractVehicle
     */
    public AbstractVehicle createVehicleWithPosition(String v, int xPos, int yPos) {
        AbstractVehicle av = null;

        switch (v) {
            case "Saab 95":
                av = new Saab95(xPos, yPos);
                break;
            case "Volvo 240":
                av = new Volvo240(xPos, yPos);
                System.out.println("created a Volvo 240");
                break;
            case "Scania":
                av = new Scania(xPos, yPos);
                break;
            case "Volvo Truck":
                av = new VolvoTruck(xPos, yPos);
                break;
            case "Ferry":
                av = new BoatyMcBoatFace(xPos, yPos);
            default:
                System.out.println("Couldn't create vehicle - bad parameter");
                break;
        }
        return av;
    }

}

public class VehicleFactory {

    public VehicleFactory() {

    }

    public AbstractVehicle createVehicle(String v) {
        return createVehicleWithNoPosition(v);
    }

    public AbstractVehicle createVehicle(String v, int xPos, int yPos) {
        return createVehicleWithNoPosition(v, xPos, yPos);
    }

    /**
     * Create a vehicle with no position
     * @param v
     * @return
     */
    public AbstractVehicle createVehicleWithNoPosition(String v) {
        AbstractVehicle av = null;

        switch (v) {
            case "Saab":
                av = new Saab95();
                break;
            case "Volvo":
                av = new Volvo240();
                System.out.println("created a volvo kuk40");
                break;
            case "Scania":
                av = new Scania();
                break;
            case "VolvoTruck":
                av = new VolvoTruck();
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
     * @param v
     * @return
     */
    public AbstractVehicle createVehicleWithNoPosition(String v, int xPos, int yPos) {
        AbstractVehicle av = null;

        switch (v) {
            case "Saab":
                av = new Saab95(xPos, yPos);
                break;
            case "Volvo":
                av = new Volvo240(xPos, yPos);
                System.out.println("created a volvo kuk40");
                break;
            case "Scania":
                av = new Scania(xPos, yPos);
                break;
            case "VolvoTruck":
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

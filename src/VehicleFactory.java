public class VehicleFactory {

    AbstractVehicle av;

    public VehicleFactory() {

    }

    public AbstractVehicle createVehicle(String v) {
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

}

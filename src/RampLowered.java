public class RampLowered implements VehicleState {

    AbstractTruck truck;

    public RampLowered(AbstractTruck truck) {
        this.truck = truck;
    }
    @Override
    public void raiseRamp() {
        System.out.println("Raising ramp");
        truck.setVehicleState(truck.getRampRaisedState());
    }

    @Override
    public void lowerRamp() {
        System.out.println("Ramp is already raised");
    }

    @Override
    public void gas() {
        System.out.println("Vroom");
    }

    @Override
    public void brake() {
        System.out.println("Eeeek.");
    }
}

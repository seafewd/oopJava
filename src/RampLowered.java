public class RampLowered implements VehicleState {

    AbstractVehicle vehicle;

    public RampLowered(AbstractVehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void raiseRamp() {
        System.out.println("Raising ramp");
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

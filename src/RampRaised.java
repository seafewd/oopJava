public class RampRaised implements VehicleState {

    AbstractVehicle vehicle;

    public RampRaised(AbstractVehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void raiseRamp() {
        System.out.println("Ramp is already raised.");
    }

    @Override
    public void lowerRamp() {
        System.out.println("Lowering ramp.");
    }

    @Override
    public void gas() {
        System.out.println("Can't drive while ramp is raised!");
    }

    @Override
    public void brake() {
        System.out.println("Braking. RIP cargo");
    }
}

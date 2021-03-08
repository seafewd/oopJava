public class RampRaised implements VehicleState {

    AbstractTruck truck;

    public RampRaised(AbstractTruck truck) {
        this.truck = truck;
    }

    @Override
    public void raiseRamp() {
        System.out.println("Ramp is already raised.");
    }

    @Override
    public void lowerRamp() {
        System.out.println("Lowering ramp.");
        truck.setVehicleState(truck.getRampLoweredState());
    }

    @Override
    public void gas() {
        System.out.println("Drive mf drive!");
    }

    @Override
    public void brake() {
        System.out.println("Braking. RIP cargo");
    }

    @Override
    public boolean move() {
        System.out.println("Moooooving");
        return true;
    }
}

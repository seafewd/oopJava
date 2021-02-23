public class Ramp {

    private final AbstractTruck truck;

    /**
     * Min angle of ramp
     */
    private final static int MIN_ANGLE = 0;

    /**
     * Max angle of ramp
     */
    private final static int MAX_ANGLE = 70;

    /**
     * Angle of the LoadingTruck's ramp
     */
    private int rampAngle;

    public Ramp(AbstractTruck truck) {
        this.truck = truck;
    }

    /**
     * Set angle of ramp
     * Require a minimum and a maximum angle in order to set
     * Also require that the speed of truck is 0
     * @param degree    degree with which to set the ramp angle
     */
    protected boolean setAngle(int degree) {
        if (truck.getCurrentSpeed() == 0 && (rampAngle >= MIN_ANGLE && rampAngle <= MAX_ANGLE)) {
            rampAngle = degree;
            return true;
        }
        return false;
    }


    /**
     * Get current angle of ramp
     * @return angle
     */
    public int getAngle() {
        return rampAngle;
    }
}

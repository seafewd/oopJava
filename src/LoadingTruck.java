import java.awt.*;

public abstract class LoadingTruck extends MotorVehicle {
    private Platform platform;
    private static int MIN_ANGLE = 0;
    private static int MAX_ANGLE = 70;

    public LoadingTruck(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName) {
        super(nrDoors, enginePower, currentSpeed, color, modelName);
        platform = new Platform();
    }

    /**
     * Inner class used by loading trucks with platform loaders
     */
    public class Platform {
        private int angle;

        public Platform() {
            angle = 0;
        }

        /**
         * Set angle of platform
         * Require a minimum and a maximum angle in order to set
         * Also require that the speed of truck is 0
         * @param truck     truck
         * @param degree    degree with which to set the platform angle
         */
        protected boolean setAngle(LoadingTruck truck, int degree) {
            if (truck.getCurrentSpeed() == 0 && (angle >= MIN_ANGLE && angle <= MAX_ANGLE)) {
                angle = degree;
                return true;
            }
            return false;
        }

        /**
         * Get current angle of platform
         * @return
         */
        public int getAngle() {
            return angle;
        }
    }

    /**
     * Increment speed
     * Require that the truck platform is down in order to increment speed
     * @param amount The amount with which to increment
     */
    protected void incrementSpeed(double amount){
        if (platform.getAngle() == 0)
            super.incrementSpeed(amount);
        else
            System.out.println("Can't move unless platform angle is 0");
    }

    /**
     * Decrement speed
     * @param amount The amount with which to decrement
     */
    protected void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    /**
     * Get the truck's platform
     * @return
     */
    public Platform getPlatform() {
        return platform;
    }
}

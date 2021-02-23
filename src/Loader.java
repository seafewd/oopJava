import java.util.Collection;

public class Loader<T extends AbstractMovable> {

    Collection<T> load;

    /**
     * Loading distance
     */
    private final int loadingDistance;

    /**
     * Maximum amount of Cars that will fit
     */
    protected int maxLoad;


    public Loader(int loadingDistance) {
        this.loadingDistance = loadingDistance;

    }

     /**
     * Check if car is close enough to the transport to be able to be loaded onto it
     * @param t     T to check
     * @return      Proximity check
     */
    public boolean isCloseEnoughToLoad(T t) {
        boolean isCloseX = this.xPos < t.getXPos() + loadingDistance && this.xPos > t.getXPos() - loadingDistance;
        boolean isCloseY = this.yPos < t.getYPos() + loadingDistance && this.yPos > t.getYPos() - loadingDistance;
        return isCloseX && isCloseY;
    }

    /**
     * Get cargo load
     * @return  Cargo load
     */
    public Collection<T> getLoad() {
        return load;
    }

    /**
     * Check if loading is possible (e.g. not exceeding maximum amount of cars already in transport)
     */
    public boolean transportNotFull() {
        if (load.size() < maxLoad) {
            return true;
        }
        System.out.println("Transport is full!");
        return false;
    }
}

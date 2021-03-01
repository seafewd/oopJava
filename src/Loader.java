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
     * Get loading distance
     * @return loading distance
     */
    public int getLoadingDistance() {
        return loadingDistance;
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

import java.util.ArrayList;
import java.util.Deque;

public class Atransporter extends Athing {

    Deque<Atransportee> load;
    /**
     * Loading distance
     */
    protected static double LOADING_DISTANCE = 20;
    protected  double CARGOHOLD_VOLUME;
    protected  double CARGOHOLD_MAXWEIGHT;

    public Atransporter(String itsName, double xPos, double yPos, double xDim, double yDim, double zDim, double weight, double cargoWeightCap, double cargoVolumeCap) {
        super(itsName, xPos, yPos, xDim, yDim, zDim, weight);
        this.CARGOHOLD_VOLUME = cargoVolumeCap;
        this.CARGOHOLD_MAXWEIGHT = cargoWeightCap;
    }

    public Deque<Atransportee> getLoad() {
        return load;
    }

    public double getCargoWeight() {
        double weight = 0;
        for (Atransportee transp : load)
        {
            weight += transp.getWeight();
        }
        return weight;
    }

    public double getCargoDim() {
        double dimension = 0;
        for (Atransportee transp : load)
        {
            dimension += transp.getxDim()* transp.getyDim()*transp.getzDim();
        }
        return dimension;
    }

    public void loadCargo(Atransportee toBeTransported){
        if (transporterNotFull(toBeTransported) && isCloseEnoughToLoad(toBeTransported))
            load.add(toBeTransported);
    }

    protected boolean transporterNotFull(Atransportee toBeTransported) {
        if (this.getCargoDim()+toBeTransported.getVolume() < CARGOHOLD_VOLUME &&
                this.getCargoWeight()+toBeTransported.getWeight() < CARGOHOLD_MAXWEIGHT) {
            return true;
        }
        System.out.println("Transport is full!");
        return false;
    }


    protected boolean isCloseEnoughToLoad(Atransportee toBeTransported) {
        boolean isCloseX = this.xPos < toBeTransported.getxPos() + LOADING_DISTANCE && this.xPos > toBeTransported.getxPos() - LOADING_DISTANCE;
        boolean isCloseY = this.yPos < toBeTransported.getyPos() + LOADING_DISTANCE && this.xPos > toBeTransported.getyPos() - LOADING_DISTANCE;
        return isCloseX && isCloseY;
    }

}

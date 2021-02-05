public class Athing {
    /**
     * The thingymajing everyday name
     */
    protected String itsName;

    /**
     * Current x-position
     */
    protected double xPos;

    /**
     * Current y-position
     */
    protected double yPos;

    /**
     * Current x-dimension
     */
    protected double xDim;

    /**
     * Current y-dimension
     */
    protected double yDim;

    /**
     * Current z-dimension
     */
    protected double zDim;

    /**
     * Thingy weight
     */
    protected double weight;

    public Athing(String itsName, double xPos, double yPos, double xDim, double yDim, double zDim, double weight) {
        this.itsName = itsName;
        this.xPos = xPos;
        this.yPos = yPos;
        this.xDim = xDim;
        this.yDim = yDim;
        this.zDim = zDim;
        this.weight = weight;
    }


    public String getItsName() {
        return itsName;
    }

    public double getxPos() {
        return xPos;
    }

    public void setxPos(double xPos) {
        this.xPos = xPos;
    }

    public double getyPos() {
        return yPos;
    }

    public void setyPos(double yPos) {
        this.yPos = yPos;
    }

    public double getxDim() {
        return xDim;
    }

    public void setxDim(double xDim) {
        this.xDim = xDim;
    }

    public double getyDim() {
        return yDim;
    }

    public void setyDim(double yDim) {
        this.yDim = yDim;
    }

    public double getzDim() {
        return zDim;
    }

    public double getVolume() {
        return xDim*yDim*zDim;
    }

    public void setzDim(double zDim) {
        this.zDim = zDim;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}

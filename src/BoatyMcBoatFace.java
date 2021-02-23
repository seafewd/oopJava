import java.awt.*;

public class BoatyMcBoatFace implements Transporter<Transportable> {

    private Loader<Transportable> dt;

    public BoatyMcBoatFace() {
        this.dt = new Loader<>(5, 3000, 0, Color.BLACK, "BoatyMcBoatFace", 90000);
    }

    @Override
    public boolean load(Transportable t) {
        return dt.load(t);
    }

    @Override
    public Transportable unload(int vehiclesToUnload) {
        return dt.unload(vehiclesToUnload);
    }
}

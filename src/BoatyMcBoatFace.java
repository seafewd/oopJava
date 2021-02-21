import java.awt.*;
import java.util.LinkedList;

public class BoatyMcBoatFace implements Transporter<Transportable> {

    private DefaultTransporter<Car> dt;

    public BoatyMcBoatFace() {
        this.dt = new DefaultTransporter<>(5, 3000, 0, Color.BLACK, "BoatyMcBoatFace", 90000);
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

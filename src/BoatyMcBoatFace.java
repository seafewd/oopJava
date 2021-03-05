import java.awt.*;

public class BoatyMcBoatFace extends AbstractFerry {

    public BoatyMcBoatFace() {
        super(5, 3000, 0, Color.BLACK, "BoatyMcBoatFace", 90000, 20);
    }

    public BoatyMcBoatFace(int xPos, int yPos) {
        super(xPos, yPos, 5, 3000, 0, Color.BLACK, "BoatyMcBoatFace", 90000, 20);
    }

}

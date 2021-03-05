import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.util.List;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    List<AbstractVehicle> vehicleList;
    Assets assets = new Assets();
    BufferedImage vehicleImage;

    void updateImage(AbstractVehicle vehicle){
        try {
            vehicleImage = assets.getAssociatedImage(vehicle);
        }catch (IllegalArgumentException e){ // TODO: fix potential errors
            System.out.println("Missing image");
        }
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, CarModel carModel) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.lightGray);
        this.vehicleList = carModel.getVehicles();
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (AbstractVehicle vehicle:vehicleList
             ) {
            int x = (int) Math.round(vehicle.getXPos());
            int y = (int) Math.round(vehicle.getYPos());
            updateImage(vehicle);
            g.drawImage(vehicleImage, x, y, null);
        }
    }
}

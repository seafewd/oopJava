import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    Assets assets = new Assets();
    // Just a single image, TODO: Generalize
    BufferedImage vehicleImage;
    Point vehiclePosition;


    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;

    Point volvoPoint = new Point();
    Point saabPoint = new Point();
    Point scaniaPoint = new Point();

    void paint(){
        //updateImage();
        repaint();
    }

    void updateImage(AbstractVehicle vehicle){
        try {
            vehicleImage = assets.getAssociatedImage(vehicle);
        }catch (IllegalArgumentException e){ // TODO: fix potential errors
            System.out.println("Missing image");
        }
    }

    // TODO: Make this genereal for all cars
    void moveit(int x, int y, AbstractVehicle vehicle){
        vehiclePosition.x = x;
        vehiclePosition.y = y;
        /*
        if(vehicle instanceof Volvo240){
            volvoPoint.x = x;
            volvoPoint.y = y;
        }else if(vehicle instanceof Saab95){
            saabPoint.x = x;
            saabPoint.y = y;
        }else if(vehicle instanceof Scania){
            scaniaPoint.x = x;
            scaniaPoint.y = y;
        }else
            System.out.println("No vehicle found");


         */

    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        //pointList.add(volvoPoint);
        //pointList.add(saabPoint);
        //pointList.add(scaniaPoint);

        // Print an error message in case file is not found with a try/catch block
        //try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            //volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/volvo.jpg"));
            //saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/saab.jpg"));
            //scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/scania.jpg"));
        //} catch (IOException ex)
        //{
        //    ex.printStackTrace();
        //}

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(vehicleImage, volvoPoint.x, volvoPoint.y, null);
        //g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null); // see javadoc for more info on the parameters
        //g.drawImage(saabImage, saabPoint.x, saabPoint.y, null); // see javadoc for more info on the parameters
        //g.drawImage(scaniaImage, scaniaPoint.x, scaniaPoint.y, null); // see javadoc for more info on the parameters
    }

    public BufferedImage getImage() {
        return volvoImage;
    }



}

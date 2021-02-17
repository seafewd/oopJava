import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;

    // To keep track of a single car's position
    Point volvoPoint = new Point();

    //List<Point> pointList = new ArrayList<>();

    // TODO: Make this genereal for all cars
    void moveit(int x, int y){
        volvoPoint.x = x;
        volvoPoint.y = y;
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
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/volvo.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/saab.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/scania.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null); // see javadoc for more info on the parameters
        g.drawImage(saabImage, volvoPoint.x, volvoPoint.y+100, null); // see javadoc for more info on the parameters
        g.drawImage(scaniaImage, volvoPoint.x, volvoPoint.y+200, null); // see javadoc for more info on the parameters
    }

    public BufferedImage getImage() {
        return volvoImage;
    }
}

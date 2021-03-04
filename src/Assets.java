import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

public class Assets {
    private static final String IMAGE_DIR = "pics/";

    /**
     * Dictionary to link a vehicle/movable to an image
     * For example, a volvo240 should have a specific image of a volvo, etc
     */
    private final static Map<Object, Image> objectImageMap = new HashMap<Object, Image>();

    /**
     * Constructor.
     * Bind images to the classes
     */
    Assets(){
        bind(Volvo240.class, "volvo.jpg");
        bind(Saab95.class, "saab.jpg");
        bind(Scania.class, "scania.jpg");
    }

    /**
     * Get image for the given object
     *
     * @param object the object that is linked to the Image (movable/vehicles in our case)
     * @param imageFileName file name of the vehicle image
     */

    public void bind(Object object, String imageFileName){
        /*
        pseudo:
        1. Get the image from dir
        2. if image is not null:
                link the object and the image with the map
           else:
                throw exception
         */
        Image image = getImage(imageFileName); // image of movable

        if(image != null){
            objectImageMap.put(object, image);
        }
        else{
            throw new IllegalArgumentException("No image found in :" + IMAGE_DIR + imageFileName);
        }
    }

    public Image getAssociatedImage(Object object){
        /*
        pseudo:
        1. Get the right image by passing in the given object as key to the map
        2. If the image is not null:
                return the image bound to the object
           else:
                return the image bound to the class of the object
         */
        Image image = objectImageMap.get(object);

        if (image == null) {
            return objectImageMap.get(object.getClass());  // .. if fail, check if class bound
        }
        return image;

    }

    // Helpers ------

    private Image getImage(String fileName){return new Image(IMAGE_DIR + fileName);}

    private Image getImage(String fileName, int width, int height){
        return new Image(IMAGE_DIR + fileName, width, height, true, true);
    }

}

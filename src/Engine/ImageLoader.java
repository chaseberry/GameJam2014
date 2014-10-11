package Engine;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by chase on 10/11/14.
 */
public class ImageLoader {

    public static BufferedImage getImage(String name, Object parent) {
        try {
            return ImageIO.read(parent.getClass().getResource("../Images/" + name));
        } catch (IOException ex) {
        }
        return null;


    }

}

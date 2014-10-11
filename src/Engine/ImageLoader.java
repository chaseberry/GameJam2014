package Engine;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
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

    public static BufferedImage copyImage(BufferedImage bi) {
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }


}

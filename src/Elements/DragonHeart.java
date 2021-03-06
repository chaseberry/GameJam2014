package Elements;

import Engine.ImageLoader;

import java.awt.*;

/**
 * Created by chase on 10/11/14.
 */
public class DragonHeart extends Element {

    public DragonHeart(int x, int y){
        super(x, y, "Dragon Heart", "The fiery heart of a dragon.");
        img = ImageLoader.getImage("DragonHeart.png", this);
    }

    @Override
    public String getElementType() {
        return "fire";
    }

    @Override
    public Color getElementColor() {
        return new Color(175, 50, 75);
    }
}

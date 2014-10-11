package Elements;

import Engine.ImageLoader;

import java.awt.*;

/**
 * Created by chase on 10/11/14.
 */
public class GlisteningCrystal extends Element {

    public GlisteningCrystal(int x, int y){
        super(x, y, "Quartz Crystal", "A shining quartz crystal");
        img = ImageLoader.getImage("GlisteningCrystal.png", this);
    }

    @Override
    public String getElementType() {
        return "light";
    }

    @Override
    public Color getElementColor() {
        return new Color(255, 251, 205);
    }
}

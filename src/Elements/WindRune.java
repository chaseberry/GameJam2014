package Elements;

import Engine.ImageLoader;

import java.awt.*;

/**
 * Created by chase on 10/11/14.
 */
public class WindRune extends Element {

    public WindRune(int x, int y){
        super(x, y, "Wind Rune", "A rune that floats in the wind");
        img = ImageLoader.getImage("WindRune.png", this);
    }

    @Override
    public String getElementType() {
        return "wind";
    }

    @Override
    public Color getElementColor() {
        return new Color(0, 231, 152);
    }
}

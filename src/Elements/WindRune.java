package Elements;

import Engine.ImageLoader;

/**
 * Created by chase on 10/11/14.
 */
public class WindRune extends Element {

    public WindRune(int x, int y){
        super(x, y, "Wind Rune", "A rune that floats in the wind");
        img = ImageLoader.getImage("WindRune.png", this);
    }
}

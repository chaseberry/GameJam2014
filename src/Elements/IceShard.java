package Elements;

import Engine.ImageLoader;

import java.awt.*;

/**
 * Created by chase on 10/11/14.
 */
public class IceShard extends Element {

    public IceShard(int x, int y){
        super(x, y, "Ice Shard", "A sharp chunk of ice.");
        img = ImageLoader.getImage("IceShard.png", this);
    }

    @Override
    public String getElementType() {
        return "water";
    }

    @Override
    public Color getElementColor() {
        return new Color(100, 220, 200);
    }
}

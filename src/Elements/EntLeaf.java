package Elements;

import Engine.ImageLoader;

/**
 * Created by chase on 10/11/14.
 */
public class EntLeaf extends Element {

    public EntLeaf(int x, int y){
        super(x, y, "Ent Leaf", "A leaf fallen from a mighty Ent");
        img = ImageLoader.getImage("EntLeaf.png", this);
    }
}

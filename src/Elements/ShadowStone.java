package Elements;

import Engine.ImageLoader;

/**
 * Created by chase on 10/11/14.
 */
public class ShadowStone extends Element {

    public ShadowStone(int x, int y){
        super(x, y, "Shadow Stone", "A stone imbued with dark secrets");
        img = ImageLoader.getImage("ShadowStone.png", this);
    }
}

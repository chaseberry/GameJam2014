package Elements;

import Engine.ImageLoader;

/**
 * Created by chase on 10/11/14.
 */
public class ChargedIron extends Element {

    public ChargedIron(int x, int y){
        super(x, y, "Charged Iron", "An electrifying chunk of iron");
        img = ImageLoader.getImage("ChargedIron.png", this);
    }

    @Override
    public String getElementType() {
        return "electricity";
    }
}

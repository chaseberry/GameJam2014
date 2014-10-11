package Players;

import java.awt.image.BufferedImage;

/**
 * Created by chase on 10/11/14.
 */
public class Inventory {

    private ElementalPouch pouch;

    public Inventory(){
        pouch = new SmallPouch();
    }

    public ElementalPouch getPouch(){
        return pouch;
    }

    public BufferedImage getImage(){
        BufferedImage pouchImage = pouch.getImage();
        //Addstuff
        return pouchImage;
    }
}

package Elements;

import Engine.ImageLoader;

/**
 * Created by chase on 10/11/14.
 */
public class GlisteningCrystal extends Element {

    public GlisteningCrystal(int x, int y){
        super(x, y, "Glistening Crystal", "A shining quartz crystal");
        img = ImageLoader.getImage("GlisteningCrystal.png", this);
    }
}

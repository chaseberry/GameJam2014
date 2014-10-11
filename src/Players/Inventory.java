package Players;

import Engine.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Inventory {

    private ElementalPouch pouch;
    private BufferedImage img;

    public Inventory() {
        pouch = new SmallPouch();
        img = ImageLoader.getImage("InventoryMenu.png", this);
    }

    public ElementalPouch getPouch() {
        return pouch;
    }

    public JPanel getImage() {
        return getPouch().getImage();
    }

}

package Players;

import Elements.*;
import Engine.Engine;
import Engine.ImageLoader;
import UI.ElementFrame;
import UI.ElementalPouchFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.util.HashMap;

/**
 * Created by chase on 10/11/14.
 */
public class ElementalPouch {

    protected final int maxCount;
    protected HashMap<String, Integer> elementMap;
    protected int elementCount = 0;
    private BufferedImage layerImage;
    private Element[] elementList;
    private Element[] selectedElementList;

    //**UI stuff
    private ElementFrame[] elementFrames;
    private ElementalPouchFrame pouchFrame;
    //

    public ElementalPouch() {
        this(5);
    }

    public ElementalPouch(int maxCount) {
        this.maxCount = maxCount;
        elementMap = new HashMap<String, Integer>();
        layerImage = ImageLoader.getImage("InventoryElementLayer.png", this);
        loadElements();
    }

    private void loadElements() {
        elementList = new Element[7];
        elementList[0] = new DragonHeart(0, 0);
        elementList[1] = new ChargedIron(0, 1);
        elementList[2] = new EntLeaf(0, 2);
        elementList[3] = new GlisteningCrystal(0, 3);
        elementList[4] = new IceShard(0, 4);
        elementList[5] = new ShadowStone(0, 5);
        elementList[6] = new WindRune(0, 6);
    }

    public boolean canHoldElement() {
        if (elementCount == maxCount) {
            return false;
        }
        return true;
    }

    public boolean addElement(String element) {
        if (elementCount == maxCount) {
            return false;
        }
        if (elementMap.get(element) == null) {
            elementMap.put(element, 1);
        } else {
            elementMap.put(element, elementMap.get(element) + 1);
        }
        elementCount++;
        return true;
    }

    public JPanel getImage() {
        if(elementFrames == null){
            elementFrames = new ElementFrame[7];
            for (int z = 0; z < elementList.length; z++) {
                Element element = elementList[z];
                BufferedImage layerClone = ImageLoader.copyImage(layerImage);
                Graphics g = layerClone.getGraphics();
                g.setColor(element.getElementColor());
                g.fillRect(0, 0, Engine.imageSize, Engine.imageSize);
                int count = elementMap.get(element.getElementType()) == null ? 0 : elementMap.get(element.getElementType());
                g.setFont(new Font(null, 0, 28));
                g.drawString(String.valueOf(count), 45, 30);
                elementFrames[z] = new ElementFrame(elementList[z], layerClone, null, null);
            }
        }else{
            //Need a forloop forupdating BS;
        }
        if(pouchFrame == null){
            pouchFrame = new ElementalPouchFrame(elementFrames);
        }


        return pouchFrame;
    }

    public boolean difuseElement(String element) {
        if (elementMap.get(element) == null || elementMap.get(element) == 0) {
            return false;
        }
        elementMap.put(element, elementMap.get(element) - 1);
        return true;
    }

}

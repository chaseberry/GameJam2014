package UI;

import Elements.Element;
import Engine.Engine;
import Players.ElementalPouch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by chase on 10/11/14.
 */
public class ElementalPouchFrame extends JPanel {

    private CraftingFrame craftingFrame;

    public ElementalPouchFrame(ElementFrame[] elements, ActionListener removeItemListener){
        super();
        setBackground(new Color(255,255,255, 0));
        setLayout(null);
        setVisible(true);
        setSize(300, Engine.imageSize * 8 + (/*Buffer*/5) * 8);
        for(int z=0; z<7; z++){
            elements[z].setLocation(0, (32 * z) + (5 * z));
            add(elements[z]);
        }

        craftingFrame = new CraftingFrame(removeItemListener);
        craftingFrame.setLocation(0, (32 * 7) + (5 * 7));
        add(craftingFrame);
    }

    public boolean addElementToCraft(Element element){
        return craftingFrame.addElement(element);
    }

    public void removeElementToCraft(ActionEvent e){
        craftingFrame.removeElement(e);
    }

}

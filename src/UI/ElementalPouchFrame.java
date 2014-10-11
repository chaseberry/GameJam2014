package UI;

import Engine.Engine;
import Players.ElementalPouch;

import javax.swing.*;
import java.awt.*;

/**
 * Created by chase on 10/11/14.
 */
public class ElementalPouchFrame extends JPanel {

    public ElementalPouchFrame(ElementFrame[] elements){
        super();
        setBackground(new Color(255,255,255, 0));
        setLayout(null);
        setVisible(true);
        setSize(300, Engine.imageSize * 8 + (/*Buffer*/5) * 8);
        for(int z=0; z<7; z++){
            elements[z].setLocation(0, (32 * z) + (5 * z));
            add(elements[z]);
        }
    }



}

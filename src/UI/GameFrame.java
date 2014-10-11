package UI;

import Engine.Engine;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by chase on 10/11/14.
 */
public class GameFrame extends JPanel {

    BufferedImage img;

    private JPanel inventoryPane = null;

    public GameFrame(){
        setVisible(true);
        requestFocus();
        setBackground(new Color(255,255,255, 0));
        int frameSize = Engine.imageSize * Engine.numberOfSquares;
        setSize(frameSize + getInsets().left + getInsets().right, frameSize + getInsets().top + getInsets().bottom);
    }

    public void addInventoryFrame(JPanel pane){
        if(inventoryPane != null){
            return;
        }
        pane.setLocation(10, 10);
        pane.setVisible(true);
        add(pane);
        inventoryPane = pane;
        repaint();
    }

    public void removeInventoryFrame(){
        if(inventoryPane == null){
            return;
        }
        remove(inventoryPane);
        inventoryPane = null;
    }


    public void setImage(BufferedImage img){
        this.img = img;
    }

    @Override
    public void paint(Graphics g){
        g.drawImage(img, 0, 0, null);
        super.paint(g);
    }
}

package UI;

import Elements.Element;
import Engine.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

/**
 * Created by chase on 10/11/14.
 */
public class ElementFrame extends JPanel {

    private BufferedImage img;

    public ElementFrame(Element element, BufferedImage img, ActionListener elementListener, ActionListener defuseListener) {
        super();
        this.img = img;
        setBackground(new Color(255, 255, 255, 0));
        setLayout(null);
        setBorder(null);
        setSize(200, 32);
        JButton elementButton = new JButton(new ImageIcon(element.getImage()));
        elementButton.setBorder(BorderFactory.createEmptyBorder());
        elementButton.setLocation(0, 0);
        elementButton.setSize(32, 32);
        elementButton.setToolTipText(element.getName());
        elementButton.addActionListener(elementListener);
        elementButton.setName(element.getElementType());
        add(elementButton);
        JButton defuseButton = new JButton(new ImageIcon(ImageLoader.getImage("DifuseButtonImage.png", this)));
        defuseButton.setBorder(BorderFactory.createEmptyBorder());
        defuseButton.setLocation(100, 5);
        defuseButton.setSize(76, 24);
        defuseButton.setToolTipText("Defuse an element to gather mana");
        defuseButton.setName(element.getElementType());
        defuseButton.addActionListener(defuseListener);
        add(defuseButton);
        repaint();
    }

    public void setImage(BufferedImage img){
        this.img = img;
    }

    @Override
    public void paint(Graphics g) {

        if (img != null) {
            g.drawImage(img, 0, 0, null);
        }

        super.paint(g);
    }

}

package Players;


import Engine.Engine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Character {

    private double x;
    private double y;
    private Inventory inventory;
    private int health;
    private int mana;
    private int maxHealth = 3;
    private int maxMana = 10;


    ActionListener defuseButtonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String element =  ((JButton)e.getSource()).getName();
            if(!getInventory().getPouch().canPopElement(element)){
                return;
            }
            if(getInventory().getPouch().difuseElement(element)){
                mana += 3;
                if(mana > maxMana){
                    mana = maxMana;
                }
            }
        }
    };

    ActionListener selectElementListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String element =  ((JButton)e.getSource()).getName();
            if(!getInventory().getPouch().canPopElement(element)){
                return;
            }

        }
    };

    public Character() {
        x = 10;
        y = 10;
        health = 3;
        mana = 10;
        inventory = new Inventory();
        inventory.getPouch().setActionListeners(new ActionListener[]{selectElementListener, defuseButtonListener});
    }

    public BufferedImage getImage() {
        BufferedImage img = new BufferedImage(Engine.imageSize, Engine.imageSize, BufferedImage.TYPE_INT_ARGB);
        Graphics g = img.getGraphics();
        g.setColor(Color.RED);
        g.fillRect(0, 0, Engine.imageSize, Engine.imageSize);
        return img;
    }

    public void moveX(double distance) {
        x += distance;
    }

    public void moveY(double distance) {
        y += distance;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getHealth() {
        return health;
    }

    public int getMana() {
        return mana;
    }

    public void mouseClicked(int x, int y){

    }
}

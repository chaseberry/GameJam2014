package Players;


import Engine.Engine;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Character {

    private double x;
    private double y;

    public Character(){
        x = 10;
        y = 10;
    }

    public BufferedImage getImage(){
        BufferedImage img = new BufferedImage(Engine.imageSize, Engine.imageSize, BufferedImage.TYPE_INT_ARGB);
        Graphics g = img.getGraphics();
        g.setColor(Color.RED);
        g.fillRect(0,0,Engine.imageSize,Engine.imageSize);
        return img;
    }

    public void moveX(double distance){
        x += distance;
    }

    public void moveY(double distance){
        y += distance;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y){
        this.y = y;
    }
    public void setX(double x){
        this.x = x;
    }
}

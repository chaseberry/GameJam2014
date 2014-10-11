package Mapping;

import Engine.ImageLoader;

import java.awt.image.BufferedImage;

public class Tile {

    private int x;
    private int y;
    private TileType.Type type;
    BufferedImage img;

    public Tile(int x, int y, TileType.Type type){
        this.x = x;
        this.y = y;
        this.type = type;
        updateImage();
    }

    private void updateImage(){
        String fileName = "";
        switch(this.type){
            case FOREST:
                fileName = "Forest.png";
                break;
            case PLAIN:
                fileName = "Plains.png";
                break;
            case RIVER:

                break;
        }
        img = ImageLoader.getImage(fileName, this);
    }

    public BufferedImage getImage(){
        return img;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public TileType.Type getType() {
        return type;
    }

    public void setType(TileType.Type type) {
        this.type = type;
        updateImage();
    }
}

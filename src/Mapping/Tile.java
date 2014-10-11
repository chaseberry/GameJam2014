package Mapping;

import java.awt.image.BufferedImage;

public class Tile {

    private int x;
    private int y;
    private TileType.Type type;
    BufferedImage img;

    public Tile(int x, int y, TileType.Type type){

    }

    public BufferedImage getImage(){
        return null;//TODO
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
    }
}

package Mapping;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Block {

    public static final int NORTH = 0;
    public static final int SOUTH = 1;
    public static final int EAST = 2;
    public static final int WEST = 3;

    public static final int WILLCOLLIDE = 0;
    public static final int WILLNOTCOLLIDE = 1;
    public static final int SHOULDTRANSITION = 2;

    private Tile[][] tileMap;

    public Block(int seed) {
        tileMap = new Tile[20][20];
        generateBlock();
    }

    public Block() {
        this((int) (Math.random() * 1000));
    }

    public int willCollide(double newX, double newY) {
        int x = (int) newX, y = (int) newY;
        if (Math.floor(newY) < 0 || (y + 1) > 19 || Math.floor(newX) < 0 || (x + 1) > 19) {
            return SHOULDTRANSITION;
        }
        Tile[] tiles = {tileMap[x][y], tileMap[x + 1][y], tileMap[x][y + 1], tileMap[x + 1][y + 1]};

        for(int z=0; z<4; z++){
            if(tiles[z].getType()== TileType.Type.FOREST){
                return WILLCOLLIDE;
            }
        }
        return WILLNOTCOLLIDE;
    }

    private void generateBlock() {
        for (int z = 0; z < 20; z++) {
            for (int v = 0; v < 20; v++) {
                tileMap[z][v] = new Tile(z, v, TileType.Type.PLAIN);
            }
        }
        tileMap[8][8].setType(TileType.Type.FOREST);
        tileMap[3][3].setType(TileType.Type.FOREST);
        tileMap[5][8].setType(TileType.Type.FOREST);
        tileMap[12][3].setType(TileType.Type.FOREST);
        tileMap[8][3].setType(TileType.Type.FOREST);
        tileMap[3][19].setType(TileType.Type.FOREST);
    }

    public BufferedImage getImage() {
        BufferedImage img = new BufferedImage(640, 640, BufferedImage.TYPE_INT_ARGB);
        Graphics g = img.getGraphics();
        for (int z = 0; z < 20; z++) {
            for (int v = 0; v < 20; v++) {
                g.drawImage(tileMap[z][v].getImage(), 32 * z, 32 * v, null);
            }
        }
        return img;
    }

    public int getNextBlock(double newX, double newY){
        int x = (int) newX, y = (int) newY;
        if (Math.floor(newY) < 0) {
            return NORTH;
        }
        if((y + 1) > 19){
            return SOUTH;
        }
        if(Math.floor(newX) < 0){
            return WEST;
        }
        if((x + 1) > 19){
            return EAST;
        }
        return -1;
    }

}

package Mapping;

import Engine.Engine;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Block {

    public static final int NORTH = 0;
    public static final int SOUTH = 1;
    public static final int EAST = 2;
    public static final int WEST = 3;

    public static final int WILLCOLLIDE = 0;
    public static final int WILLNOTCOLLIDE = 1;
    public static final int SHOULDTRANSITION = 2;

    private Tile[][] tileMap;
    private int seed;

    private Runnable blockGenerationRunnable = new Runnable() {
        @Override
        public void run() {
            generateBlock();
        }
    };

    public Block(int seed) {
        tileMap = new Tile[Engine.numberOfSquares][Engine.numberOfSquares];
        this.seed = seed;
        if(seed > 0) {
            new Thread(blockGenerationRunnable).start();
        }else{
            generateBlock();
        }
    }

    public Block() {
        this((int) (Math.random() * 1000));
    }

    public int willCollide(double newX, double newY) {
        int x = (int) newX, y = (int) newY;
        if (Math.floor(newY) < 0 || (y + 1) > (Engine.numberOfSquares - 1) || Math.floor(newX) < 0 || (x + 1) > (Engine.numberOfSquares - 1)) {
            return SHOULDTRANSITION;
        }
        Tile[] tiles = {tileMap[x][y], tileMap[x + 1][y], tileMap[x][y + 1], tileMap[x + 1][y + 1]};

        for (int z = 0; z < 4; z++) {
            if (tiles[z].getType() == TileType.Type.FOREST) {
                return WILLCOLLIDE;
            }
        }
        return WILLNOTCOLLIDE;
    }

    private void generateBlock() {
        Random r = new Random(seed);
        for (int z = 0; z < Engine.numberOfSquares; z++) {
            for (int v = 0; v < Engine.numberOfSquares; v++) {
                int type = r.nextInt(50);
                if(type > 45){
                    tileMap[z][v] = new Tile(z, v, TileType.Type.FOREST);
                }else{
                    tileMap[z][v] = new Tile(z, v, TileType.Type.PLAIN);
                }
            }
        }
    }

    public BufferedImage getImage() {
        int frameSize = Engine.imageSize * Engine.numberOfSquares;
        BufferedImage img = new BufferedImage(frameSize, frameSize, BufferedImage.TYPE_INT_ARGB);
        Graphics g = img.getGraphics();
        for (int z = 0; z < Engine.numberOfSquares; z++) {
            for (int v = 0; v < Engine.numberOfSquares; v++) {
                g.drawImage(tileMap[z][v].getImage(), Engine.imageSize * z, Engine.imageSize * v, null);
            }
        }
        return img;
    }

    public int getNextBlock(double newX, double newY) {
        int x = (int) newX, y = (int) newY;
        if (Math.floor(newY) < 0) {
            return NORTH;
        }
        if ((y + 1) > (Engine.numberOfSquares - 1)) {
            return SOUTH;
        }
        if (Math.floor(newX) < 0) {
            return WEST;
        }
        if ((x + 1) > (Engine.numberOfSquares - 1)) {
            return EAST;
        }
        return -1;
    }

}

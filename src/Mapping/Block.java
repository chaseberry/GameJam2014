package Mapping;

public class Block {

    private Tile[][] tileMap;

    public Block(int seed){
        tileMap = new Tile[20][20];
    }
    public Block(){
        this((int)(Math.random() * 1000));
    }
}

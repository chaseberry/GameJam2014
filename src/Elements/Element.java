package Elements;


import java.awt.image.BufferedImage;

public abstract class Element {

    protected BufferedImage img;
    protected int x;
    protected int y;
    protected String name;
    protected String description;

    public BufferedImage getImage(){
        return img;
    }

    public Element(int x, int y, String name, String description){
        this.x = x;
        this.y = y;
        this.name = name;
        this.description = description;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public abstract String getElementType();

    public static Element getRandomElement(int x, int y){
        int element = (int) (Math.random() * 7);
        switch (element){
            case 0:
                return new EntLeaf(x, y);
            case 1:
                return new ShadowStone(x, y);
            case 2:
                return new GlisteningCrystal(x, y);
            case 3:
                return new ChargedIron(x, y);
            case 4:
                return new WindRune(x, y);
            case 5:
                return new DragonHeart(x, y);
            case 6:
                return new IceShard(x, y);
        }
        return null;
    }

}

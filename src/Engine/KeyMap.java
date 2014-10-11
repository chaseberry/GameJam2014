package Engine;


public class KeyMap {

    public static final int UP = 38;
    public static final int LEFT = 37;
    public static final int DOWN = 40;
    public static final int RIGHT = 39;

    private boolean up = false;
    private boolean left = false;
    private boolean down = false;
    private boolean right = false;

    public void keyPressed(int keyCode){
        switch(keyCode){
            case UP:
                up = true;
                break;
            case DOWN:
                down = true;
                break;
            case LEFT:
                left = true;
                break;
            case RIGHT:
                right = true;
                break;
        }
    }

    public void keyReleased(int keyCode){
        switch(keyCode){
            case UP:
                up = false;
                break;
            case DOWN:
                down = false;
                break;
            case LEFT:
                left = false;
                break;
            case RIGHT:
                right = false;
                break;
        }
    }

    public boolean isUpPressed(){
        return up;
    }

    public boolean isDownPressed(){
        return down;
    }

    public boolean isLeftPressed(){
        return left;
    }

    public boolean isRightPressed(){
        return right;
    }

}

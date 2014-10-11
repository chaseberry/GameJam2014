package Engine;


import Mapping.Block;
import Players.Character;
import UI.Frame;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

public class Engine {

    private Frame frame;
    private KeyMap keyMap;
    private Timer gameTimer;
    private Character player;
    private Block currentBlock;

    private TimerTask gameTimerTask = new TimerTask() {
        @Override
        public void run() {
            gameTick();
        }
    };

    public static void main(String[] args) {
        new Engine();
    }

    public Engine(){
        keyMap = new KeyMap();
        player = new Character();
        frame = new Frame(this);
        gameTimer = new Timer();
        gameTimer.scheduleAtFixedRate(gameTimerTask, 50, 50);//20fps
    }

    protected void gameTick(){
        movePlayer();//Player movement
        //AI movement
        //Object movement
        frame.refreshFrame();//redraw
    }

    private void movePlayer(){//collide here
        double moveX = 0, moveY = 0;
        if(keyMap.isUpPressed()){
            moveY -= .12;
        }
        if(keyMap.isDownPressed()){
            moveY += .12;
        }
        if(keyMap.isLeftPressed()){
            moveX -= .12;
        }
        if(keyMap.isRightPressed()){
            moveX += .12;
        }
        if(moveY != 0 && moveX != 0){
            moveX /= 2;
            moveY /= 2;
        }
        player.moveX(moveX);
        player.moveY(moveY);
    }

    public BufferedImage getGameImage(){
        BufferedImage gameImage = new BufferedImage(640, 640, BufferedImage.TYPE_INT_ARGB);
        Graphics g = gameImage.getGraphics();
        g.clearRect(0, 0, 640, 640);
        g.drawImage(player.getImage(), (int)(32 * player.getX()), (int)(32 * player.getY()), null);
        return gameImage;
    }

    public void keyPressed(int keyCode){
        keyMap.keyPressed(keyCode);
    }

    public void keyReleased(int keyCode){
        keyMap.keyReleased(keyCode);
    }


}

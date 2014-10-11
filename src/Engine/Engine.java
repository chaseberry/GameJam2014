package Engine;


import UI.Frame;

import java.util.Timer;
import java.util.TimerTask;

public class Engine {

    private Frame frame;
    private KeyMap keyMap;
    private Timer gameTimer;


    private TimerTask gameTimerTask = new TimerTask() {
        @Override
        public void run() {

        }
    };

    public static void main(String[] args) {
        new Engine();
    }

    public Engine(){
        Frame frame = new Frame(this);
        keyMap = new KeyMap();
        //gameTimer = new Timer();
        //gameTimer.scheduleAtFixedRate(gameTimerTask, 50, 50);//20fps
    }

    public void keyPressed(int keyCode){
        keyMap.keyPressed(keyCode);
    }

    public void keyReleased(int keyCode){
        keyMap.keyReleased(keyCode);
    }


}

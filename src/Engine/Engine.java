package Engine;


import Mapping.Block;
import Players.Character;
import UI.Frame;
import UI.GameFrame;

import javax.swing.*;
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
    private Block[] nextBlocks;

    private GameFrame gameFrame;

    private final int maxAnimationMove = 12;
    public static final int imageSize = 32;
    public static final int numberOfSquares = 12;

    private int lastBlock = -1;
    private int animationCount = 0;

    private boolean displayMenu = false;

    private TimerTask gameTimerTask = new TimerTask() {
        @Override
        public void run() {
            gameTick();
        }
    };

    public static void main(String[] args) {
        new Engine();
    }

    public Engine() {
        keyMap = new KeyMap();
        player = new Character();
        currentBlock = new Block(-1);
        nextBlocks = new Block[4];
        generateNextBlocks(lastBlock);
        //These must be the last two to init
        gameFrame = new GameFrame();
        frame = new Frame(this);
        gameTimer = new Timer();
        gameTimer.scheduleAtFixedRate(gameTimerTask, 50, 50);//20fps
    }

    private void loadSpells(){

    }

    protected void gameTick() {
        if (keyMap.isMenuPressed()) {
            displayMenu = !displayMenu;
        }
        if (!displayMenu) {
            if (animationCount == 0) {
                endTransition();
            }
            if (animationCount < 1) {
                movePlayer();//Player movement
                //AI movement
                //Object movement
            } else {
                animationCount--;
            }
        }
        frame.refreshFrame();//redraw
    }

    private void movePlayer() {//collide here
        double moveX = 0, moveY = 0;
        if (keyMap.isUpPressed()) {
            moveY -= .12;
        }
        if (keyMap.isDownPressed()) {
            moveY += .12;
        }
        if (keyMap.isLeftPressed()) {
            moveX -= .12;
        }
        if (keyMap.isRightPressed()) {
            moveX += .12;
        }
        if (moveY != 0 && moveX != 0) {
            moveX /= 2;
            moveY /= 2;
        }
        int collision = currentBlock.willCollide(player.getX() + moveX, player.getY() + moveY);
        if (collision == Block.WILLNOTCOLLIDE || collision == Block.COLLIDEWITHELEMENT) {
            player.moveX(moveX);
            player.moveY(moveY);
        }

        if (collision == Block.COLLIDEWITHELEMENT) {
            if (player.getInventory().getPouch().canHoldElement()) {
                player.getInventory().getPouch().addElement(currentBlock.takeBlockElement().getElementType());
            }
        }

        if (collision == Block.SHOULDTRANSITION) {
            startTransition(currentBlock.getNextBlock(player.getX() + moveX, player.getY() + moveY));
        }

    }

    private void generateNextBlocks(int keep) {
        for (int z = 0; z < 4; z++) {
            if (z != keep) {
                nextBlocks[z] = new Block();
            }
        }
    }

    private void startTransition(int newBlock) {
        if (newBlock == -1) {
            System.out.println("I don't even");
            return;
        }
        switch (newBlock) {
            case Block.NORTH:
                nextBlocks[Block.SOUTH] = currentBlock;
                currentBlock = nextBlocks[Block.NORTH];
                lastBlock = Block.SOUTH;
                player.setY(Engine.numberOfSquares - 1.12);
                break;
            case Block.EAST:
                nextBlocks[Block.WEST] = currentBlock;
                currentBlock = nextBlocks[Block.EAST];
                lastBlock = Block.WEST;
                player.setX(0);
                break;
            case Block.WEST:
                nextBlocks[Block.EAST] = currentBlock;
                currentBlock = nextBlocks[Block.WEST];
                lastBlock = Block.EAST;
                player.setX(Engine.numberOfSquares - 1.12);
                break;
            case Block.SOUTH:
                nextBlocks[Block.NORTH] = currentBlock;
                currentBlock = nextBlocks[Block.SOUTH];
                lastBlock = Block.NORTH;
                player.setY(0);
                break;
        }
        animationCount = maxAnimationMove;
        generateNextBlocks(lastBlock);
    }

    private void endTransition() {
        animationCount = 0;
    }

    public void updateGameImage() {
        int frameSize = Engine.numberOfSquares * Engine.imageSize;
        BufferedImage gameImage = new BufferedImage(frameSize, frameSize, BufferedImage.TYPE_INT_ARGB);
        Graphics g = gameImage.getGraphics();
        if (displayMenu) {
            gameFrame.addInventoryFrame(player.getInventory().getImage());
            return;
        }

        gameFrame.removeInventoryFrame();

        if (animationCount == 0) {
            g.drawImage(currentBlock.getImage(), 0, 0, null);
            g.drawImage(player.getImage(), (int) (Engine.imageSize * player.getX()), (int) (Engine.imageSize * player.getY()), null);
            gameFrame.setImage(gameImage);
            return;
        }
        if (lastBlock == -1) {
            endTransition();
            updateGameImage();
            return;
        }
        g.drawImage(getTransitionImage(), 0, 0, null);
        gameFrame.setImage(gameImage);
    }

    public GameFrame getGameFrame() {
        return gameFrame;
    }

    private BufferedImage getTransitionImage() {
        double frameSize = imageSize * numberOfSquares;
        BufferedImage transitionImage = new BufferedImage((int) frameSize, (int) frameSize, BufferedImage.TYPE_INT_ARGB);
        Graphics g = transitionImage.getGraphics();
        double percentMoved = ((maxAnimationMove - animationCount) / (double) maxAnimationMove);
        switch (lastBlock) {
            case Block.NORTH://slide UP
                int newYN = (int) ((frameSize) * (1 - percentMoved));//640-->0
                g.drawImage(currentBlock.getImage(), 0, newYN, null);
                int oldYN = (int) ((-frameSize) * (percentMoved));//0-->-640
                g.drawImage(nextBlocks[lastBlock].getImage(), 0, oldYN, null);
                break;
            case Block.SOUTH://slide DOWN
                int newYS = (int) (-frameSize * (1 - percentMoved));//-640-->0
                g.drawImage(currentBlock.getImage(), 0, newYS, null);
                int oldYS = (int) ((frameSize) * percentMoved);//0-->640
                g.drawImage(nextBlocks[lastBlock].getImage(), 0, oldYS, null);
                break;
            case Block.EAST://slide EAST
                int newXE = (int) (-frameSize * (1 - percentMoved));//-640-->0;
                int oldXE = oldYS = (int) ((frameSize) * percentMoved);//0-->640
                g.drawImage(currentBlock.getImage(), newXE, 0, null);
                g.drawImage(nextBlocks[lastBlock].getImage(), oldXE, 0, null);
                break;
            case Block.WEST://slide WEST
                int newXW = (int) ((frameSize) * (1 - percentMoved));//640-->0
                int oldXW = (int) ((-frameSize) * (percentMoved));//0-->-640
                g.drawImage(currentBlock.getImage(), newXW, 0, null);
                g.drawImage(nextBlocks[lastBlock].getImage(), oldXW, 0, null);
                break;
        }
        return transitionImage;
    }

    public void keyPressed(int keyCode) {
        keyMap.keyPressed(keyCode);
    }

    public void keyReleased(int keyCode) {
        keyMap.keyReleased(keyCode);
    }

    public void mousePressed(int x, int y) {

    }

}

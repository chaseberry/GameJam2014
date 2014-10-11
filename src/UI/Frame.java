package UI;

import Engine.Engine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;


public class Frame extends JFrame implements KeyListener, MouseListener {

    private Engine engine;


    public Frame(Engine engine) {
        super();
        this.engine = engine;
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        addKeyListener(this);
        requestFocus();
        int frameSize = Engine.imageSize * Engine.numberOfSquares;
        setSize(frameSize + getInsets().left + getInsets().right, frameSize + getInsets().top + getInsets().bottom);
        engine.getGameFrame().setLocation(0, 0);
        add(engine.getGameFrame());
    }

    public void refreshFrame() {
        engine.updateGameImage();
        if(!hasFocus()){
            requestFocus();
        }
        repaint();
    }


    //***KEY LISTENERS

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        engine.keyPressed(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        engine.keyReleased(e.getKeyCode());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            engine.mousePressed(e.getX(), e.getY());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    //***END KEY LISTENERS
}

package UI;

import Engine.Engine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;


public class Frame extends JFrame implements KeyListener {

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
    }

    public void refreshFrame() {
        repaint();
    }

    @Override
    public void paint(Graphics graphics) {
        BufferedImage img = engine.getGameImage();
        graphics.drawImage(img, getInsets().left, getInsets().top, null);
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

    //***END KEY LISTENERS
}

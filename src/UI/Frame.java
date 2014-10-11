package UI;

import Engine.Engine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Frame extends JFrame implements KeyListener {

    private Engine engine;

    public Frame(Engine engine) {
        super();
        this.engine = engine;
        setSize(640 + getInsets().left + getInsets().right, 640 + getInsets().top + getInsets().bottom);
        setVisible(true);
        repaint();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        addKeyListener(this);
    }

    public void refreshFrame() {

    }

    @Override
    public void paint(Graphics graphics) {


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

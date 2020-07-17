package view;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import controller.Features;

public class CanvasView extends JFrame implements SnakeView, KeyListener {

  private final int scale;
  private Features controller;


  public CanvasView(IViewModel model, int scale) {
    super();

    this.scale = scale;

    int scaledWidth = model.getWidth() * scale;
    int scaledHeight = model.getHeight() * scale;

    this.setSize(scaledWidth, scaledHeight);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());

    Field field = new Field(model, scale);

    field.setPreferredSize(new Dimension(scaledWidth, scaledHeight));
    this.add(field);


    this.setVisible(true);
    this.pack();

    this.validate();

  }

  @Override
  public void repaint() {
    super.repaint();
  }

  @Override
  public void keyTyped(KeyEvent e) {
    System.out.println("key");
    if (e.getKeyCode() == KeyEvent.VK_UP) {
      this.controller.turnUp();
    }
    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
      this.controller.turnRight();
    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
      this.controller.turnDown();
    }
    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
      this.controller.turnLeft();
    }
  }

  @Override
  public void keyPressed(KeyEvent e) {

  }

  @Override
  public void keyReleased(KeyEvent e) {

  }

  @Override
  public void setFeatures(Features f) {
    this.controller = f;
  }
}

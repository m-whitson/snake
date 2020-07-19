package view;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.*;

import controller.Features;
import model.Cell;

public class Field extends JPanel implements KeyListener {

  IViewModel model;

  private final int scale;

  List<Cell> snake;
  Cell food;
  Features controller;

  public Field(IViewModel model, int scale) {
    this.model = model;
    this.scale = scale;
    this.snake = this.model.getSnake();
    this.food = this.model.getFood();
  }



  @Override
  public void paintComponent(Graphics g) {
    this.snake = this.model.getSnake();

    super.paintComponent(g);
    this.setBackground(Color.BLACK);

    g.setColor(Color.ORANGE);
    g.fillRect(this.food.getX() * scale, this.food.getY() * scale, scale, scale);

    g.setColor(Color.WHITE);
    for (Cell c: this.snake) {
      g.fillRect(c.getX() * scale, c.getY() * scale, scale, scale);
    }

  }

  @Override
  public void keyTyped(KeyEvent e) {
    //System.out.println("typed");
  }

  @Override
  public void keyPressed(KeyEvent e) {
    int code = e.getKeyCode();
    //System.out.println("pressed");
    this.turn(code);
  }

  @Override
  public void keyReleased(KeyEvent e) {
    //System.out.println("released");
  }

  public void turn(int code) {
    if (code == KeyEvent.VK_UP) {
      this.controller.turnUp();
    }
    if (code == KeyEvent.VK_RIGHT) {
      this.controller.turnRight();
    }
    if (code == KeyEvent.VK_DOWN) {
      this.controller.turnDown();
    }
    if (code == KeyEvent.VK_LEFT) {
      this.controller.turnLeft();
    }
  }

  public void setFeatures(Features controller) {
    this.controller = controller;
  }

}

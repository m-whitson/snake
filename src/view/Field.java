package view;


import java.awt.*;
import java.util.List;

import javax.swing.*;

import model.Cell;

public class Field extends JPanel {

  IViewModel model;

  private final int scale;

  List<Cell> snake;
  Cell food;

  public Field(IViewModel model, int scale) {
    this.model = model;
    this.scale = scale;
    this.snake = this.model.getSnake();
    this.food = this.model.getFood();
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    this.setBackground(Color.BLACK);

    g.setColor(Color.ORANGE);
    g.fillRect(this.food.getX() * scale, this.food.getY() * scale, scale, scale);

    g.setColor(Color.WHITE);
    for (Cell c: this.snake) {
      g.fillRect(c.getX() * scale, c.getY() * scale, scale, scale);
    }

  }
}

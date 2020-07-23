package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

/**
 * Represents the actual snake in the game. Contains getter methods and void methods
 * which control the snake's movement.
 */
public class Snake extends JComponent {

  private Heading heading;

  private Cell head;

  private int length;

  // INVARIANT: body.length() = this.length
  private List<Cell> body;

  private SnakeModel model;

  private Cell food;

  public Snake(SnakeModel model) {
    this.heading = Heading.Right;
    this.head = new Cell(2, 2);
    this.body = new ArrayList<Cell>();
    this.length = 1;
    this.model = model;

  }

  /**
   * @return the snake's current heading.
   */
  public Heading getHeading() {
    return this.heading;
  }

  /**
   * Changes the snake's heading to the given heading.
   * @param newHeading the new direction for the snake to face.
   */
  public void face(Heading newHeading) {
    this.heading = newHeading;
    repaint();
  }

  /**
   * @return the snake's current length.
   */
  public int getLength() {
    return this.length;
  }

  /**
   * Is the given object part of this snake?
   * @param o the given object.
   * @return true if o is a cell that the snake contains.
   */
  public boolean contains(Object o) {
    return this.head.equals(o) || this.body.contains(o);
  }

  /**
   * Advances the snake forward one space. Should be called per tick.
   */
  public void moveForward() {
    int nextX = this.head.getX();
    int nextY = this.head.getY();
    if (this.heading == Heading.Right) {
      nextX++;
    }
    if (this.heading == Heading.Left) {
      nextX--;
    }
    if (this.heading == Heading.Down) {
      nextY++;
    }
    if (this.heading == Heading.Up) {
      nextY--;
    }
    if (nextX == -1 || nextY == -1 ||
            nextX == this.model.getWidth() || nextY == this.model.getHeight()) {
      // snake runs into a wall
      this.endGame();
      return;
    }
    Cell newCell = new Cell(nextX, nextY);
    if (this.body.contains(newCell)) {
      // snake runs into itself
      this.endGame();
    } else {

      // snake gets the food!
      if (newCell.equals(this.food)) {
        this.length += 5;
        this.model.newFood();
        this.food = this.model.getFood();
      }

      if (this.length > 1) {
        if (this.body.size() >= this.length) {
          this.body.remove(0);
        }
        this.body.add(this.head);
      }
      this.head = newCell;

    }


  }

  /**
   * Ends the game. Should be called if the snake runs into itself or a wall.
   */
  protected void endGame() {
    this.model.endGame();
  }

  /**
   * All of the cells that make up this snake.
   * @return a list of Cells.
   */
  public List<Cell> getAllCells() {
    List<Cell> cells = new ArrayList<Cell>(this.body);
    cells.add(this.head);
    return cells;
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);

  }

  public void setFood(Cell c) {
    this.food = c;
  }


}

package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the actual snake in the game. Contains getter methods and void methods
 * which control the snake's movement.
 */
public class Snake {

  private Heading heading;

  private Cell head;

  private int length;

  // INVARIANT: body.length() == this.length
  private List<Cell> body;

  public Snake() {
    this.heading = Heading.Right;
    this.head = new Cell(2, 2);
    this.body = new ArrayList<Cell>();
    this.length = 1;
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
    return this.head.equals(o) && this.body.contains(o);
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
    Cell newCell = new Cell(nextX, nextY);
    if (this.body.contains(newCell)) {
      // snake runs into itself
      this.endGame();
    } else {
      this.body.add(this.head);
      this.body.remove(0);
      this.head = newCell;
    }
  }

  /**
   * Ends the game. Should be called if the snake runs into itself or a wall.
   */
  protected void endGame() {
    // might need a reference to the model
  }

}

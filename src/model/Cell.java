package model;

/**
 * One square on the board. A snake is made up of cells,
 * and food is also represented with a cell.
 */
public class Cell {

  private int x;
  private int y;

  public Cell(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * @return the x position of this cell.
   */
  public int getX() {
    return this.x;
  }
  /**
   * @return the y position of this cell.
   */
  public int getY() {
    return this.y;
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof Cell) {
      Cell c = (Cell)o;
      return c.getX() == this.x && c.getY() == this.y;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return this.x + this.y;
  }
}

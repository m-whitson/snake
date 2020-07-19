import java.util.ArrayList;
import java.util.List;

import model.Cell;
import model.Heading;
import model.SnakeModel;
import view.IViewModel;

public class MockModel implements SnakeModel, IViewModel {

  private StringBuilder log;

  public MockModel() {
    this.log = new StringBuilder();
  }

  @Override
  public boolean isGameOver() {
    this.log.append("isGameOver");
    return false;
  }

  @Override
  public int length() {
    this.log.append("length");
    return 0;
  }

  @Override
  public void turnUp() {
    this.log.append("turnUp");
  }

  @Override
  public void turnRight() {
    this.log.append("turnRight");
  }

  @Override
  public void turnDown() {
    this.log.append("turnDown");
  }

  @Override
  public void turnLeft() {
    this.log.append("turnLeft");
  }

  @Override
  public void endGame() {
    this.log.append("endGame");
  }

  @Override
  public void advance() {
    this.log.append("advance");
  }

  @Override
  public List<Cell> getSnake() {
    this.log.append("getSnake");
    return new ArrayList<Cell>();
  }

  @Override
  public Cell getFood() {
    this.log.append("getFood");
    return new Cell(0,0);
  }

  @Override
  public int getWidth() {
    this.log.append("getWidth");
    return 0;
  }

  @Override
  public int getHeight() {
    this.log.append("getHeight");
    return 0;
  }

  @Override
  public Heading getHeading() {
    this.log.append("getHeading");
    return Heading.Right;
  }

  /**
   * Getter method for the log.
   * @return the log.
   */
  public String getLog() {
    return this.log.toString();
  }

}

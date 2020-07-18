import model.Heading;
import model.SnakeModel;

public class MockModel implements SnakeModel {

  private String log;

  public MockModel() {
    this.log = "";
  }

  @Override
  public boolean isGameOver() {
    this.log = "isGameOver";
    return false;
  }

  @Override
  public int length() {
    this.log = "length";
    return 0;
  }

  @Override
  public void turnUp() {
    this.log = "turnUp";
  }

  @Override
  public void turnRight() {
    this.log = "turnRight";
  }

  @Override
  public void turnDown() {
    this.log = "turnDown";
  }

  @Override
  public void turnLeft() {
    this.log = "turnLeft";
  }

  @Override
  public void endGame() {
    this.log = "endGame";
  }

  @Override
  public void advance() {
    this.log = "advance";
  }

  @Override
  public int getWidth() {
    this.log = "getWidth";
    return 0;
  }

  @Override
  public int getHeight() {
    this.log = "getHeight";
    return 0;
  }

  @Override
  public Heading getHeading() {
    this.log = "getHeading";
    return Heading.Right;
  }

}

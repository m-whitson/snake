package model;


import java.util.Random;

/**
 * Implememtation of the SnakeModel interface.
 */
public class SnakeModelImpl implements SnakeModel {

  private final int width;
  private final int height;

  private Snake snake;

  private Cell food;

  private Random rand;

  public SnakeModelImpl(int w, int h) {
    this.width = w;
    this.height = h;
    this.snake = new Snake();
    this.rand = new Random();
    this.newFood();
  }

  @Override
  public boolean isGameOver() {
    return false;
  }

  @Override
  public int length() {
    return this.snake.getLength();
  }

  @Override
  public void turnUp() {
    Heading curr = this.snake.getHeading();
    if (curr != Heading.Up && curr != Heading.Down) {
      this.snake.face(Heading.Up);
    }
  }

  @Override
  public void turnRight() {
    Heading curr = this.snake.getHeading();
    if (curr != Heading.Right && curr != Heading.Left) {
      this.snake.face(Heading.Right);
    }
  }

  @Override
  public void turnDown() {
    Heading curr = this.snake.getHeading();
    if (curr != Heading.Up && curr != Heading.Down) {
      this.snake.face(Heading.Down);
    }
  }

  @Override
  public void turnLeft() {
    Heading curr = this.snake.getHeading();
    if (curr != Heading.Right && curr != Heading.Left) {
      this.snake.face(Heading.Left);
    }
  }

  @Override
  public void newFood() {
    int foodX = rand.nextInt(this.width);
    int foodY = rand.nextInt(this.height);
    Cell f = new Cell(foodX, foodY);
    if (this.snake.contains(f)) {
      this.newFood();
    } else {
      this.food = f;
    }
  }
}

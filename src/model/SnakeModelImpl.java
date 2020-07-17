package model;


import java.util.List;
import java.util.Random;

import view.IViewModel;

/**
 * Implememtation of the SnakeModel interface.
 */
public class SnakeModelImpl implements SnakeModel, IViewModel {

  private final int width;
  private final int height;

  public Snake snake;

  private Cell food;

  private Random rand;

  private boolean over;

  public SnakeModelImpl(int w, int h) throws IllegalArgumentException {
    if (w < 1 || h < 1) {
      throw new IllegalArgumentException("invalid field size");
    }
    this.width = w;
    this.height = h;
    this.snake = new Snake(this);
    this.rand = new Random();
    this.newFood();
    this.over = false;
  }

  @Override
  public boolean isGameOver() {
    return this.over;
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

  /**
   * Creates a new food on the board.
   */
  private void newFood() {
    int foodX = rand.nextInt(this.width);
    int foodY = rand.nextInt(this.height);
    Cell f = new Cell(foodX, foodY);
    if (this.snake.contains(f)) {
      this.newFood();
    } else {
      this.food = f;
    }
  }

  @Override
  public void endGame() {
    this.over = true;
  }

  @Override
  public List<Cell> getSnake() {
    return this.snake.getAllCells();
  }

  @Override
  public Cell getFood() {
    return this.food;
  }

  @Override
  public int getWidth() {
    return this.width;
  }

  @Override
  public int getHeight() {
    return this.height;
  }

  @Override
  public Heading getHeading() {
    return this.snake.getHeading();
  }

  @Override
  public void advance() {
    this.snake.moveForward();
  }
}

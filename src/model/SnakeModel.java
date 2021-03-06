package model;

/**
 * This interface represents the operations offered by the snake model:
 * managing game state and enforcing the rules. One object of the model
 * represents one game of snake.
 */
public interface SnakeModel {

  /**
   * Is this game over?
   * @return true if game is over, false otherwise.
   */
  boolean isGameOver();

  /**
   * Finds current length of the snake.
   * @return an int length.
   */
  int length();

  /**
   * Turn the snake so it faces up.
   * (does nothing if snake is facing down)
   */
  void turnUp();

  /**
   * Turn the snake so it faces right.
   * (does nothing if snake is facing left)
   */
  void turnRight();

  /**
   * Turn the snake so it faces down.
   * (does nothing if snake is facing up)
   */
  void turnDown();

  /**
   * Turn the snake so it faces left.
   * (does nothing if snake is facing right)
   */
  void turnLeft();


  /**
   * Ends the game.
   */
  void endGame();

  /**
   * Moves the snake forward.
   */
  void advance();

  /**
   * @return the width of this model.
   */
  int getWidth();

  /**
   * @return the height of this model.
   */
  int getHeight();

  /**
   * @return the Heading of this model at the current moment.
   */
  Heading getHeading();

  /**
   * @return the Cell where the food is currently located.
   */
  Cell getFood();

  /**
   * Reassigns the food field to a new Cell in the Field (which is not already part of the Snake)
   */
  void newFood();

  /**
   * @return the current length of the Snake.
   */
  int getLength();
}
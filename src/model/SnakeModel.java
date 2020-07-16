package model;

/**
 * This interface represents the operations offered by the snake model:
 * managing game state and enforcing the rules. One object of the model
 * represents one game of snake.
 */
public interface SnakeModel {

  boolean isGameOver();

  int length();

  void turnUp();


}
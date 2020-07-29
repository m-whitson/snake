package view;

import java.util.List;

import model.Cell;
import model.Snake;

/**
 * Represents a ViewModel class that extracts data from a Model to give to a View. This is done to
 * manage data privacy and prevent unnecessary access to the Model from the View.
 */
public interface IViewModel {

  /**
   * Returns all the cells that make up the Snake object.
   * @return a List<Cell> </Cell> representing the Snaie.
   */
  List<Cell> getSnake();

  /**
   * Returns the food at the current moment.
   * @return the Cell where the food is located.
   */
  Cell getFood();

  /**
   * @return the width of this model.
   */
  int getWidth();

  /**
   * @return the height of this model.
   */
  int getHeight();

  void start();


}

package view;

import java.util.List;

import model.Cell;
import model.Snake;

/**
 * Represents a ViewModel class that extracts data from a Model to give to a View. This is done to
 * manage data privacy and prevent unnecessary access to the Model from the View.
 */
public interface IViewModel {

  List<Cell> getSnake();

  Cell getFood();

  int getWidth();

  int getHeight();


}

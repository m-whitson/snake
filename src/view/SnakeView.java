package view;

import controller.Features;

public interface SnakeView {

  /**
   * Repaint the view.
   */
  void repaint();

  /**
   * Gives the view a Features object to receive commands from the KeyListener.
   * @param f the given Features object.
   */
  void setFeatures(Features f);

  /**
   * Gives the view an immutable IViewModel model reference.
   * @param m the given IViewModel object.
   */
  void setModel(IViewModel m);

  /**
   * Ends the game.
   */
  void gameOver();

}

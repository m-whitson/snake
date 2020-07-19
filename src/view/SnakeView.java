package view;

import controller.Features;

public interface SnakeView {

  void repaint();

  void setFeatures(Features f);

  void setModel(IViewModel m);

  void gameOver();

}

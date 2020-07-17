package controller;

import model.SnakeModel;
import view.SnakeView;

public class ControllerImpl implements Controller {

  SnakeModel model;
  SnakeView view;

  public ControllerImpl(SnakeModel model, SnakeView view) {
    this.model = model;
    this.view = view;

  }

  @Override
  public void run(int speed) {

  }
}

package main;

import controller.Controller;
import controller.ControllerImpl;
import controller.Features;
import model.SnakeModel;
import model.SnakeModelImpl;
import view.CanvasView;
import view.IViewModel;
import view.SnakeView;

public class Main {


  public static void main(String[] args) {

    int speed = 2;

    SnakeModel model = new SnakeModelImpl(70, 40);
    SnakeView view = new CanvasView((IViewModel)model, 15);
    Controller controller = new ControllerImpl(model, view);
    view.setFeatures((Features)controller);

    controller.run(speed);

  }
}

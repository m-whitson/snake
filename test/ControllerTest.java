import org.junit.Before;

import controller.ControllerImpl;
import controller.Features;
import model.SnakeModel;
import view.CanvasView;
import view.IViewModel;
import view.SnakeView;

public class ControllerTest {

  Features controller;
  SnakeModel model;
  SnakeView view;

  @Before
  public void init() {
    model = new MockModel();
    view = new CanvasView((IViewModel)model, 10);
    controller = new ControllerImpl(model, view);
  }



}

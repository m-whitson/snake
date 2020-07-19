import org.junit.Before;
import org.junit.Test;

import java.awt.event.KeyEvent;

import controller.ControllerImpl;
import controller.Features;
import model.Heading;
import model.SnakeModel;
import model.SnakeModelImpl;
import view.CanvasView;
import view.IViewModel;

import static org.junit.Assert.assertEquals;

public class CanvasViewTest {

  SnakeModel model;
  Features controller;
  CanvasView view;

  @Before
  public void init() {
    model = new SnakeModelImpl(50, 50);
    view = new CanvasView((IViewModel)model, 10);
    controller = new ControllerImpl(model, view);
    view.setFeatures(controller);
  }

//  @Test
//  public void testKeyPressed() {
//    view.turn(KeyEvent.VK_DOWN);
//    assertEquals(model.getHeading(), Heading.Down);
//    view.turn(KeyEvent.VK_LEFT);
//    assertEquals(model.getHeading(), Heading.Left);
//    view.turn(KeyEvent.VK_UP);
//    assertEquals(model.getHeading(), Heading.Up);
//    view.turn(KeyEvent.VK_RIGHT);
//    assertEquals(model.getHeading(), Heading.Right);
//  }

}

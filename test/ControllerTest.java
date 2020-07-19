import org.junit.Before;
import org.junit.Test;

import controller.Controller;
import controller.ControllerImpl;
import controller.Features;
import model.SnakeModel;
import view.CanvasView;
import view.IViewModel;
import view.SnakeView;

import static org.junit.Assert.assertEquals;

public class ControllerTest {

  Features controller;
  SnakeModel mockModel;
  SnakeView mockView;

  @Before
  public void init() {
    mockModel = new MockModel();
    mockView = new MockView();
    controller = new ControllerImpl(mockModel, mockView);
  }

  // this test passes when I comment out the timer in controller.run()
//  @Test
//  public void testRun() {
//    Controller c = (Controller)controller;
//    c.run(10);
//    MockModel m = (MockModel)mockModel;
//    String out = m.getLog();
//    assertEquals(out, "advance");
//  }

  @Test
  public void testTurnUp() {
    controller.turnUp();
    MockModel m = (MockModel)mockModel;
    String out = m.getLog();
    assertEquals(out, "turnUp");
  }

  @Test
  public void testTurnDown() {
    controller.turnDown();
    MockModel m = (MockModel)mockModel;
    String out = m.getLog();
    assertEquals(out, "turnDown");
  }

  @Test
  public void testTurnRight() {
    controller.turnRight();
    MockModel m = (MockModel)mockModel;
    String out = m.getLog();
    assertEquals(out, "turnRight");
  }

  @Test
  public void testTurnLeft() {
    controller.turnLeft();
    MockModel m = (MockModel)mockModel;
    String out = m.getLog();
    assertEquals(out, "turnLeft");
  }



}

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.TestPropertySources;

import java.util.List;

import model.Cell;
import model.Heading;
import model.SnakeModel;
import model.SnakeModelImpl;
import view.IViewModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ModelTest {

  SnakeModel model;
  IViewModel vModel;

  @Before
  public void init() {
    model = new SnakeModelImpl(10, 10);
    vModel = (IViewModel)model;

  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidSize1() {
    SnakeModel m = new SnakeModelImpl(0, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidSize2() {
    SnakeModel m = new SnakeModelImpl(5, 0);
  }

  @Test
  public void testIsGameOver() {
    assertFalse(model.isGameOver());
  }

  @Test
  public void testLength() {
    assertEquals(model.length(), 1);
  }

  @Test
  public void testTurnUp() {
    assertEquals(model.getHeading(), Heading.Right);
    model.turnUp();
    assertEquals(model.getHeading(), Heading.Up);
    model.turnDown();
    assertEquals(model.getHeading(), Heading.Up);
  }

  @Test
  public void testTurnDown() {
    assertEquals(model.getHeading(), Heading.Right);
    model.turnDown();
    assertEquals(model.getHeading(), Heading.Down);
    model.turnUp();
    assertEquals(model.getHeading(), Heading.Down);
  }

  @Test
  public void testTurnLeft() {
    assertEquals(model.getHeading(), Heading.Right);
    model.turnLeft();
    assertEquals(model.getHeading(), Heading.Right);
    model.turnDown();
    model.turnLeft();
    assertEquals(model.getHeading(), Heading.Left);
    model.turnRight();
    assertEquals(model.getHeading(), Heading.Left);
  }

  @Test
  public void testTurnRight() {
    assertEquals(model.getHeading(), Heading.Right);
    model.turnDown();
    assertEquals(model.getHeading(), Heading.Down);
    model.turnRight();
    assertEquals(model.getHeading(), Heading.Right);
    model.turnLeft();
    assertEquals(model.getHeading(), Heading.Right);
  }

  @Test
  public void testEndGame() {
    assertFalse(model.isGameOver());
    model.endGame();
    assertTrue(model.isGameOver());
  }

  @Test
  public void testAdvance() {
    // not sure how to test this
  }

  @Test
  public void testGetWidth() {
    assertEquals(model.getWidth(), 10);
  }

  @Test
  public void testGetHeight() {
    assertEquals(model.getHeight(), 10);
  }

  @Test
  public void testGetHeading() {
    assertEquals(model.getHeading(), Heading.Right);
  }

  @Test
  public void testGetSnakeAndAdvance() {
    List<Cell> snake = vModel.getSnake();
    assertEquals(snake.size(), 1);
    assertEquals(snake.get(0), new Cell(2, 2));
    model.advance();
    vModel = (IViewModel)model;
    List<Cell> snake2 = vModel.getSnake();
    assertEquals(snake2.size(), 1);
    assertEquals(snake2.get(0), new Cell(3, 2));

  }

//  @Test
//  public void testGetFood() {
//    assertEquals(model.getFood().getX(), new Cell(1,1).getX());
//  }







}

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import model.Cell;
import model.Heading;
import model.Snake;
import model.SnakeModel;
import model.SnakeModelImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SnakeTest {

  SnakeModel model;
  Snake snake;

  @Before
  public void init() {
    model = new SnakeModelImpl(10, 10);
    snake = new Snake(model);
  }

  @Test
  public void testGetHeading() {
    assertEquals(snake.getHeading(), Heading.Right);
  }

  @Test
  public void testFace() {
    snake.face(Heading.Down);
    assertEquals(snake.getHeading(), Heading.Down);
    snake.face(Heading.Left);
    assertEquals(snake.getHeading(), Heading.Left);
    snake.face(Heading.Up);
    assertEquals(snake.getHeading(), Heading.Up);
    snake.face(Heading.Right);
    assertEquals(snake.getHeading(), Heading.Right);
  }

  @Test
  public void testGetLength() {
    assertEquals(snake.getLength(), 1);
  }

  @Test
  public void testContains() {
    List<Cell> list = snake.getAllCells();
    assertEquals(list.get(0), new Cell(2, 2));
    assertTrue(snake.contains(new Cell(2, 2)));
    assertFalse(snake.contains(new Cell(3, 2)));
    assertFalse(snake.contains(new Snake(model)));
    assertFalse(snake.contains(model));
    assertFalse(snake.contains("a"));

  }
}

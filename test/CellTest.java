import org.junit.Test;


import model.Cell;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CellTest {

  Cell example = new Cell(3, 4);

  @Test
  public void testGetX() {
    assertEquals(example.getX(), 3);
  }

  @Test
  public void testGetY() {
    assertEquals(example.getY(), 4);
  }

  @Test
  public void testEquals() {
    Cell c1 = example;
    Cell c2 = new Cell(3, 4);
    Cell c3 = new Cell(4, 3);
    assertEquals(c1, example);
    assertEquals(c2, example);
    assertFalse(c3.equals(example));
  }
}

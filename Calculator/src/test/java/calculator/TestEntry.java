package calculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
// import calculator.Entry;

/**
 * Junit test case to Entry class.
 * 
 * @author Daniel Ligory
 *
 */
class TestEntry {


  @Test
  public void testGetValue() {
    Entry e = new Entry(100f);
    assertEquals(100f, e.getValue(),
        "Tests that the getValue method returns the value of the number.");

    Entry e1 = new Entry(1230090213901239f);
    assertEquals(1230090213901239f, e1.getValue(),
        "Tests that the getValue methods returns the value of a longer number.");

  }

  @Test
  public void testGetSymbol() {
    Entry e = new Entry(Symbol.LEFT_BRACKET);
    assertEquals(Symbol.LEFT_BRACKET, e.getSymbol(),
        "Tests that getSymbol() method returns the correct symbol.");

  }


}


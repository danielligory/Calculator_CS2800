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
  void testContructor1() {
    Entry e = new Entry(100f);
    assertEquals(100f, e.getValue(), "Tests that constructor is assigning the correct value.");
    Entry e1 = new Entry(1230090213901239f);
    assertEquals(1230090213901239f, e1.getValue(),
        "Tests the constructor with a longer float to check correct value is assigned.");

  }

  @Test
  void testContructor2() {
    Entry e = new Entry(Symbol.LEFT_BRACKET);
    assertEquals(Symbol.LEFT_BRACKET, e.getSymbol(),
        "Tests the constructor to make sure the correct symbol is assigned by constructor.");

  }


}


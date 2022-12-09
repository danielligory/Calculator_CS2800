package calculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStandardCalc {
  private StandardCalc testStandardCalc;

  @BeforeEach
  public void createArray() {
    testStandardCalc = new StandardCalc();
  }

  @Test
  public void checkFirstElement() {
    assertEquals("(", testStandardCalc.makeArray("( 5 * ( 6 + 7 ) ) − 2").get(0),
        "Test first value of array is correct.");
  }

  @Test
  public void checkElements() {
    assertEquals("*", testStandardCalc.makeArray("( 5 * ( 6 + 7 ) ) − 2").get(2),
        "Test third value of array is correct.");
  }

  @Test
  public void checkArray() {
    assertEquals("[(, 5, *, (, 6, +, 7, ), ), -, 2]",
        testStandardCalc.makeArray("( 5 * ( 6 + 7 ) ) - 2").toString(),
        "Test whole array is created correctly.");
  }

  @Test
  public void testGreaterOperatorIsEmpty() {
    OpStack emptyTest1 = new OpStack();
    OpStack emptyTest2 = new OpStack();
    emptyTest1.push(Symbol.TIMES);
    assertFalse(testStandardCalc.greaterOperator(emptyTest1, emptyTest2),
        "Test false are divide is a smaller operator than times.");
  }

  @Test
  public void testGreaterOperator() {
    OpStack symbol1 = new OpStack();
    symbol1.push(Symbol.TIMES);
    OpStack symbol2 = new OpStack();
    symbol2.push(Symbol.PLUS);

    assertFalse(testStandardCalc.greaterOperator(symbol1, symbol2),
        "Test false as times is a greater operator than plus.");

    symbol1 = new OpStack();
    symbol1.push(Symbol.PLUS);
    symbol2 = new OpStack();
    symbol2.push(Symbol.MINUS);

    assertTrue(testStandardCalc.greaterOperator(symbol1, symbol2),
        "Test true as plus and minus are the same level or operator.");


    symbol1 = new OpStack();
    symbol1.push(Symbol.PLUS);
    symbol2 = new OpStack();
    symbol2.push(Symbol.PLUS);

    assertTrue(testStandardCalc.greaterOperator(symbol1, symbol2),
        "Test true as plus and plus are the same level or operator.");

    symbol1 = new OpStack();
    symbol1.push(Symbol.MINUS);
    symbol2 = new OpStack();
    symbol2.push(Symbol.MINUS);

    assertTrue(testStandardCalc.greaterOperator(symbol1, symbol2),
        "Test true as minus and minus are the same level or operator.");
  }


  @Test
  public void testEvaluate() {
    assertEquals(63, testStandardCalc.evaluate("( 5 * ( 6 + 7 ) ) - 2"),
        "Test calculations are done correctly.");
  }

  @Test
  public void testEvaluate2() {
    assertEquals(295, testStandardCalc.evaluate("7 + 9 * ( 12 / 3 ) * 8"),
        "Test calculations are done correctly.");
  }
}

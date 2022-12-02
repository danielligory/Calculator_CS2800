package calculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestRevPolishCalc {
  private RevPolishCalc testRevPolCalc;

  @BeforeEach
  public void createArray() {
    testRevPolCalc = new RevPolishCalc();
  }

  @Test
  public void checkFirstElement() {
    assertEquals("5", testRevPolCalc.makeArray("5 6 7 + * 2 -").get(0),
        "Will output the first element in the array.");
  }

  @Test
  public void checkElements() {
    assertEquals("7", testRevPolCalc.makeArray("5 6 7 + * 2 -").get(2),
        "Will output the third element in the array.");
  }

  @Test
  public void checkArray() {
    assertEquals("[5, 6, 7, +, *, 2, -]", testRevPolCalc.makeArray("5 6 7 + * 2 -").toString(),
        "Will output the whole array.");
  }

  @Test
  public void checkArrays2() {
    assertEquals("[2, 1, +, 3, *]", testRevPolCalc.makeArray("2 1 + 3 *").toString(),
        "Will output the whole array.");
  }

  @Test
  public void checkArray3() {
    assertEquals("[10, 6, 9, 3, +, -11, *, /, *, 17, +, 5, +]",
        testRevPolCalc.makeArray("10 6 9 3 + -11 * / * 17 + 5 +").toString(),
        "Will output the whole array.");
  }

  @Test
  public void testEvaluate() {
    assertEquals(63, testRevPolCalc.evaluate("5 6 7 + * 2 -"),
        "Check if the calculator returns the correct value");
  }

  @Test
  public void testEvaluate2() {
    assertEquals(21, testRevPolCalc.evaluate("1 2 + 3 4 + *"),
        "Check if the calculator returns the correct value");
  }

  @Test
  public void testEvaluate3() {
    assertEquals(15, testRevPolCalc.evaluate("1 2 3 4 + * +"),
        "Check if the calculator returns the correct value");
  }

}

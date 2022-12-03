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
        "Test first value of array is correct.");
  }

  @Test
  public void checkElements() {
    assertEquals("7", testRevPolCalc.makeArray("5 6 7 + * 2 -").get(2),
        "Test third value of array is correct.");
  }

  @Test
  public void checkArray() {
    assertEquals("[5, 6, 7, +, *, 2, -]", testRevPolCalc.makeArray("5 6 7 + * 2 -").toString(),
        "Test whole array is created correctly.");
  }

  @Test
  public void checkArrays2() {
    assertEquals("[2, 1, +, 3, *]", testRevPolCalc.makeArray("2 1 + 3 *").toString(),
        "Test again whole array is created correctly.");
  }

  @Test
  public void checkArray3() {
    assertEquals("[10, 6, 9, 3, +, -11, *, /, *, 17, +, 5, +]",
        testRevPolCalc.makeArray("10 6 9 3 + -11 * / * 17 + 5 +").toString(),
        "Test again whole array is created correctly.");
  }

  @Test
  public void testEvaluate() {
    assertEquals(63, testRevPolCalc.evaluate("5 6 7 + * 2 -"),
        "Test calculations are done correctly.");
  }

  @Test
  public void testEvaluate2() {
    assertEquals(21, testRevPolCalc.evaluate("1 2 + 3 4 + *"),
        "Test calculations are done correctly.");
  }

  @Test
  public void testEvaluate3() {
    assertEquals(15, testRevPolCalc.evaluate("1 2 3 4 + * +"),
        "Test calculations are done correctly.");
  }

}

package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.EmptyStackException;

/**
 * Junit test case to NumStack class.
 * 
 * @author Daniel Ligory
 *
 */
class TestNumStack {
  private NumStack testNumStack;

  @BeforeEach
  public void createNumStack() {
    // Test 1 Check if stack is created.
    testNumStack = new NumStack();
  }

  @Test
  public void testPush() {
    assertEquals(0, testNumStack.size(), "Test that push increased the size of an empty stack.");

    testNumStack.push(1234.123f);
    assertEquals(1, testNumStack.size(),
        "Test that push increased the size of a stack with size 1.");

    testNumStack.push(5214124.123f);
    assertEquals(2, testNumStack.size(),
        "Test that push increased the size of a stack with size 2.");

    int i = 0;
    while (i != 34) {
      testNumStack.push(4214f);
      i++;
    }
    assertEquals(36, testNumStack.size(),
        "Test that push increase the size of stack with size 36.");

  }


  @Test
  public void testPop() {
    assertThrows(EmptyStackException.class, () -> testNumStack.pop(),
        "Should not be able to pop from an Empty Stack.");
  }


  @Test
  public void pushThenPop() {
    testNumStack.push(123412.421f);
    assertEquals(123412.421f, testNumStack.pop(),
        "Test that pushing then popping returns the correct value.");
  }

  @Test
  public void pushManyThenPop() {
    testNumStack.push(123412.421f);
    testNumStack.push(16125.123f);
    testNumStack.push(612461.123f);

    assertEquals(612461.123f, testNumStack.pop(),
        "Test that many pushed and a pop will return the correct value.");
  }

  @Test
  public void pushManyThenPopMany() {
    testNumStack.push(123412.421f);
    testNumStack.push(16125.123f);
    testNumStack.push(612461.123f);
    assertEquals(612461.123f, testNumStack.pop(),
        "Test many pushed and the first pop returns the correct value.");

    assertEquals(16125.123f, testNumStack.pop(),
        "Test another pop to insure correct value is returned.");

    assertEquals(123412.421f, testNumStack.pop(),
        "Test another pop to insure correct value is returned");

  }

  @Test
  public void testIsEmpty() {
    assertEquals(true, testNumStack.isEmpty(), "Test empty stack is empty");

    testNumStack.push(123412.421f);
    assertEquals(false, testNumStack.isEmpty(), "Test stack is empty after being pushed a value.");
  }

  @Test
  public void pushThenPopThenCheckEmpty() {
    testNumStack.push(161235.531f);
    testNumStack.pop();
    assertEquals(true, testNumStack.isEmpty(),
        "Test stack is empty after being pushed and then popped.");
  }

  @Test
  public void testTop() {
    testNumStack.push(524.12f);
    assertEquals(524.12f, testNumStack.top(), "Test top returns the most recent entry of stack.");

    assertEquals(524.12f, testNumStack.top(),
        "Test top again to insure value returned is the most recent entry of stack.");
  }

}

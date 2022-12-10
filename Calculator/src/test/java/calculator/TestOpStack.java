package calculator;

import static org.junit.jupiter.api.Assertions.*;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Junit test case to OpStack class.
 * 
 * @author Daniel Ligory
 *
 */
class TestOpStack {
  private OpStack testOpStack;

  @BeforeEach
  public void createOPStack() {
    // Test 1 Check if stack is created.
    testOpStack = new OpStack();
    assertEquals(0, testOpStack.size(), "Test the size of an Empty Stack.");
  }

  @Test
  public void testPush() {
    testOpStack.push(Symbol.DIVIDE);
    assertEquals(1, testOpStack.size(),
        "Test that push increased the size of a stack with size 1.");

    testOpStack.push(Symbol.PLUS);
    assertEquals(2, testOpStack.size(),
        "Test that push increased the size of a stack with size 2.");

    int i = 0;
    while (i != 34) {
      testOpStack.push(Symbol.LEFT_BRACKET);
      i++;
    }
    assertEquals(36, testOpStack.size(), "Test that push increase the size of stack with size 36.");
  }

  @Test
  public void testPop() {
    assertThrows(EmptyStackException.class, () -> testOpStack.pop(),
        "Should not be able to pop from an Empty Stack.");

  }

  @Test
  public void pushThenPop() {
    testOpStack.push(Symbol.RIGHT_BRACKET);
    assertEquals(Symbol.RIGHT_BRACKET, testOpStack.pop(),
        "Test that pushing then popping returns the correct value.");
  }

  @Test
  public void pushManyThenPop() {
    testOpStack.push(Symbol.LEFT_BRACKET);
    testOpStack.push(Symbol.DIVIDE);
    testOpStack.push(Symbol.TIMES);

    assertEquals(Symbol.TIMES, testOpStack.pop(),
        "Test that many pushed and a pop will return the correct value.");
  }

  @Test
  public void pushManyThenPopMany() {
    testOpStack.push(Symbol.LEFT_BRACKET);
    testOpStack.push(Symbol.MINUS);
    testOpStack.push(Symbol.PLUS);
    assertEquals(Symbol.PLUS, testOpStack.pop(),
        "Test many pushed and the first pop returns the correct value.");

    assertEquals(Symbol.MINUS, testOpStack.pop(),
        "Test another pop to insure correct value is returned.");

    assertEquals(Symbol.LEFT_BRACKET, testOpStack.pop(),
        "Test another pop to insure correct value is returned");

  }

  @Test
  public void testIsEmpty() {
    assertEquals(true, testOpStack.isEmpty(), "Test empty stack is empty");

    testOpStack.push(Symbol.INVALID);
    assertEquals(false, testOpStack.isEmpty(), "Test stack is empty after being pushed a value.");
  }

  @Test
  public void pushThenPopThenCheckEmpty() {
    testOpStack.push(Symbol.INVALID);
    testOpStack.pop();
    assertEquals(true, testOpStack.isEmpty(),
        "Test stack is empty after being pushed and then popped.");
  }

  @Test
  public void testTop() {
    testOpStack.push(Symbol.MINUS);
    assertEquals(Symbol.MINUS, testOpStack.top(),
        "Test top returns the most recent entry of stack.");

    assertEquals(Symbol.MINUS, testOpStack.top(),
        "Test top again to insure value returned is the most recent entry of stack.");
  }



}

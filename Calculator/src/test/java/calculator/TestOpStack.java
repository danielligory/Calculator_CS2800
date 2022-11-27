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
  }

  @Test
  public void testPush() {
    // Test 1 Check if Stack is created properly.
    assertEquals(0, testOpStack.size(), "Check if Stack is working, size of Stack should be 0");
    // Test 2 Check if one entry was pushed properly.
    testOpStack.push(Symbol.DIVIDE);
    assertEquals(1, testOpStack.size(), "Check if size of Stack is size 1");
    // Test 3 Check if two entries was pushed properly.
    testOpStack.push(Symbol.PLUS);
    assertEquals(2, testOpStack.size(), "Check if size of Stack is size 2");
    // Test 4 Check if 36 entries was pushed properly.
    int i = 0;
    while (i != 34) {
      testOpStack.push(Symbol.LEFT_BRACKET);
      i++;
    }
    assertEquals(36, testOpStack.size(), "Check is size of Stack is 36");
  }

  @Test
  public void testPop() {
    // Test 1 Check if EmptyStackException is thrown when pop is called on Empty Stack.
    assertThrows(EmptyStackException.class, () -> testOpStack.pop(),
        "Should not be able to pop from an Empty Stack.");

  }

  @Test
  public void pushThenPop() {
    // Test 1 Check if correct value is popped when one Entry is pushed.
    testOpStack.push(Symbol.RIGHT_BRACKET);
    assertEquals(Symbol.RIGHT_BRACKET, testOpStack.pop(),
        "Checks if Stack was pushed then popped correctly.");
  }

  @Test
  public void pushManyThenPop() {
    // Test 1 Check if correct value is popped when multiple Entries are pushed.
    testOpStack.push(Symbol.LEFT_BRACKET);
    testOpStack.push(Symbol.DIVIDE);
    testOpStack.push(Symbol.TIMES);

    assertEquals(Symbol.TIMES, testOpStack.pop(),
        "Checks if Stack was pushed then popped correctly.");
  }

  @Test
  public void pushManyThenPopMany() {
    // Test 1 Check if correct value is popped when multiple Entries are pushed.
    testOpStack.push(Symbol.LEFT_BRACKET);
    testOpStack.push(Symbol.MINUS);
    testOpStack.push(Symbol.PLUS);

    assertEquals(Symbol.PLUS, testOpStack.pop(),
        "Checks if Stack was pushed then popped correctly.");
    assertEquals(Symbol.MINUS, testOpStack.pop(),
        "Checks if Stack was pushed then popped correctly.");
    assertEquals(Symbol.LEFT_BRACKET, testOpStack.pop(),
        "Checks if Stack was pushed then popped correctly.");

  }

  @Test
  public void testIsEmpty() {
    // Test 1 Check if correct value is given when given an empty set.
    assertEquals(true, testOpStack.isEmpty(), "Checks is Stack is Empty.");
    // Test 2 Check if correct value is given when an entry is pushed into the Stack.
    testOpStack.push(Symbol.INVALID);
    assertEquals(false, testOpStack.isEmpty(), "Checks is Stack is Empty.");
  }

  @Test
  public void pushThenPopThenCheckEmpty() {
    // Test 1 Check if correct value is given after Stack is Pushed, Popped and then asked if Empty.
    testOpStack.push(Symbol.INVALID);
    testOpStack.pop();
    assertEquals(true, testOpStack.isEmpty(), "Checks if Stack is Empty after pop.");
  }

  @Test
  public void testTop() {
    // Test 1 Checking if correct value is given when top method is called.
    testOpStack.push(Symbol.MINUS);
    assertEquals(Symbol.MINUS, testOpStack.top(),
        "Checks correct Entry is at the top of the Stack");
    assertEquals(Symbol.MINUS, testOpStack.top(),
        "Checking twice as Entry should not be removed when top method is called");
  }



}

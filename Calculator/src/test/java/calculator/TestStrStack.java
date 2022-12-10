package calculator;

/**
 * Junit test case to StrStack class.
 * 
 * @author Daniel Ligory
 *
 */
import static org.junit.jupiter.api.Assertions.*;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStrStack {
  private StrStack testStrStack;

  @BeforeEach
  public void createOPStack() {
    // Test 1 Check if stack is created.
    testStrStack = new StrStack();
    assertEquals(0, testStrStack.size(), "Test size of Empty Stack is 0.");
  }

  public void testPush() {
    testStrStack.push("test");
    assertEquals(1, testStrStack.size(),
        "Test that push increased the size of a stack with size 1.");

    testStrStack.push("test");
    assertEquals(2, testStrStack.size(),
        "Test that push increased the size of a stack with size 2.");

    int i = 0;
    while (i != 34) {
      testStrStack.push("test");
      i++;
    }
    assertEquals(36, testStrStack.size(),
        "Test that push increase the size of stack with size 36.");
  }

  @Test
  public void testPop() {
    assertThrows(EmptyStackException.class, () -> testStrStack.pop(),
        "Should not be able to pop from an Empty Stack.");
  }

  @Test
  public void pushThenPop() {
    testStrStack.push("test");
    assertEquals("test", testStrStack.pop(),
        "Test that pushing then popping returns the correct value.");
  }

  @Test
  public void pushManyThenPop() {
    testStrStack.push("test");
    testStrStack.push("test1");
    testStrStack.push("test2");

    assertEquals("test2", testStrStack.pop(),
        "Test that many pushed and a pop will return the correct value.");
  }

  @Test
  public void pushManyThenPopMany() {
    testStrStack.push("test");
    testStrStack.push("test1");
    testStrStack.push("test2");
    assertEquals("test2", testStrStack.pop(),
        "Test many pushed and the first pop returns the correct value.");

    assertEquals("test1", testStrStack.pop(),
        "Test another pop to insure correct value is returned.");

    assertEquals("test", testStrStack.pop(),
        "Test another pop to insure correct value is returned");

  }

  @Test
  public void testIsEmpty() {
    assertEquals(true, testStrStack.isEmpty(), "Test empty stack is empty");

    testStrStack.push("test");
    assertEquals(false, testStrStack.isEmpty(), "Test stack is empty after being pushed a value.");
  }

  @Test
  public void pushThenPopThenCheckEmpty() {
    testStrStack.push("test");
    testStrStack.pop();
    assertEquals(true, testStrStack.isEmpty(),
        "Test stack is empty after being pushed and then popped.");
  }

  @Test
  public void testTop() {
    testStrStack.push("test");
    assertEquals("test", testStrStack.top(), "Test top returns the most recent entry of stack.");

    assertEquals("test", testStrStack.top(),
        "Test top again to insure value returned is the most recent entry of stack.");
  }



}


package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Junit test case to Stack class.
 * 
 * @author Daniel Ligory
 *
 */

class TestStack {
  private Stack testStack;

  @BeforeEach
  public void createStack() {
    // Test 1 Check if stack is created.
    testStack = new Stack();
    assertEquals(testStack.size(), 0, "Test size is 0 of Empty Stack.");
  }

  @Test
  public void testPush() {
    Entry testOne = new Entry(1);
    testStack.push(testOne);
    assertEquals(testStack.size(), 1, "Test if Stack has one Entry");
    // Test 3 Check again if one entry was pushed out properly.
    testStack.push(testOne);
    assertEquals(testStack.size(), 2, "Test if Stack has two Entries");
    // Test 4 Check if multiple entries can be added properly.
    int i = 0;
    while (i < 5) {
      testStack.push(testOne);
      i++;
    }
    assertEquals(testStack.size(), 7, "Test if Stack has seven Entries");
  }

  @Test
  public void testPop() {
    // Test 1 Checks if Exception is thrown, can not pop an empty stack.
    assertThrows(EmptyStackException.class, () -> testStack.pop(),
        "Should not be able to pop from an Empty Stack.");
  }

  @Test
  public void pushThenPop() throws Exception {
    // Test 1 Checks if pushing and then pop working correctly.
    testStack.push(new Entry(1));
    assertEquals(testStack.pop().getValue(), 1,
        "Pushing a one then popping should also return one.");
    assertThrows(EmptyStackException.class, () -> testStack.pop(),
        "Should not be able to pop twice in a row with one entry");
  }

  @Test
  public void pushTwice() throws Exception {
    // Test 1 Checks if two pushes and one pop will correctly output 5.
    testStack.push(new Entry(3));
    testStack.push(new Entry(5));
    assertEquals(testStack.pop().getValue(), 5,
        "Pushing a three and five then popping should also return five.");
    // Test 2 Checks if after the first pop the second pop will work outputting 3.
    assertEquals(testStack.pop().getValue(), 3,
        "Three left in stack therefore should return three after popping.");
    // Test 3 Checks that exception if thrown as can't pop with empty stack.
    assertThrows(EmptyStackException.class, () -> testStack.pop(),
        "Should not be able to pop three times in a row with one entry left");
  }

  @Test

  public void pushMany() throws Exception {
    // Test 1 Checking when many numbers are pushed they can be popped out correctly.
    testStack.push(new Entry(5));
    testStack.push(new Entry(7));
    testStack.push(new Entry(23));
    testStack.push(new Entry(14));
    // Checks if 14 is popped out.
    assertEquals(testStack.pop().getValue(), 14,
        "Pushing five, seven, twenty-three, and fourteen then popping should return fourteen.");
    // Test 2 Checks if 23 if popped out.
    assertEquals(testStack.pop().getValue(), 23,
        "Stack remaining with five, seven, and twenty-three should pop twenty-three as its last in stack.");
    // Test 3 Checks if 7 if popped out.
    assertEquals(testStack.pop().getValue(), 7,
        "Stack remaining with five, and seven should pop seven as its last in stack.");
    // Test 4 Checks if 5 if popped out.
    assertEquals(testStack.pop().getValue(), 5,
        "Stack remaining with five therefore should pop five as its last in stack.");
    // Test 5 Checks if Exception is thrown as can't pop with empty stack.
    assertThrows(EmptyStackException.class, () -> testStack.pop(),
        "Should not be able to pop five times in a row with one entry left");
  }

  @Test
  public void testEmptyTop() {
    // Test 1 Checks if exception is thrown as can't call top on empty stack.
    assertThrows(EmptyStackException.class, () -> testStack.pop(),
        "Can not return top from an empty list.");
  }

  @Test
  public void testTop() throws Exception {
    // Test 1 Checks if 1 is the output from the top of the stack properly.
    testStack.push(new Entry(1));
    assertEquals(testStack.top().getValue(), 1, "Pushing only one, should return 1");
  }

  @Test
  public void testTwoTop() throws Exception {
    // Test 1 Checks if 2 is the output from the top of the stack properly.
    testStack.push(new Entry(1));
    testStack.push(new Entry(2));
    assertEquals(testStack.top().getValue(), 2, "Pushing one, and two should returned");
  }

  @Test
  public void testManyTop() throws Exception {
    // Test 1 Checks if 49 is returned from top of stack.
    for (int i = 0; i < 50; i++) {
      testStack.push(new Entry(i));
    }
    assertEquals(testStack.top().getValue(), 49,
        "Pushing one to fourty-nine, and fourt-nine should returned");
  }

  @Test
  public void testEmptyStack() {
    // Test 1 Checks if Empty stack is created.
    Stack testStack = new Stack();
    assertEquals(testStack.size(), 0, "Checks if stack is empty");
  }

}

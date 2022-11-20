package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.EmptyStackException;

class TestNumStack {
  private NumStack testNumStack;

  @BeforeEach
  public void createNumStack() {
   // Test 1 Check if stack is created.
    testNumStack = new NumStack();
  }
  
  @Test
  public void testPush() {
    // Test 1 Check if Stack is created properly.
    assertEquals(0, testNumStack.size(), "Check if Stack is working, size of Stack should be 0");
    // Test 2 Check if one entry was pushed properly.
    testNumStack.push(1234.123f);
    assertEquals(1, testNumStack.size(), "Check if size of Stack is size 1");
    // Test 3 Check if two entries was pushed properly.
    testNumStack.push(5214124.123f);
    assertEquals(2, testNumStack.size(), "Check if size of Stack is size 2");
    // Test 4 Check if 36 entries was pushed properly.
    int i = 0;
    while (i != 34) {
      testNumStack.push(4214f);
      i ++;
    }
    assertEquals(36, testNumStack.size(), "Check is size of Stack is 36");

  }
  
  @Test
  public void testPop() {
    // Test 1 Check if EmptyStackException is thrown when pop is called on Empty Stack.
    assertThrows(EmptyStackException.class, () -> testNumStack.pop(), 
        "Should not be able to pop from an Empty Stack."); 
  }
  
  @Test
  public void pushThenPop() {
    // Test 1 Check if correct value is popped when one Entry is pushed.
    testNumStack.push(123412.421f);
    assertEquals(123412.421f, testNumStack.pop(), 
        "Checks if Stack was pushed then popped correctly.");
  }
  
  @Test
  public void pushManyThenPop() {
    // Test 1 Check if correct value is popped when multiple Entries are pushed.
    testNumStack.push(123412.421f);
    testNumStack.push(16125.123f);
    testNumStack.push(612461.123f);
    
    assertEquals(612461.123f, testNumStack.pop(), 
        "Checks if Stack was pushed then popped correctly.");
  }
  
  @Test
  public void pushManyThenPopMany() {
   // Test 1 Check if correct value is popped when multiple Entries are pushed.
      testNumStack.push(123412.421f);
      testNumStack.push(16125.123f);
      testNumStack.push(612461.123f);
      
      assertEquals(612461.123f, testNumStack.pop(), 
          "Checks if Stack was pushed then popped correctly.");
      assertEquals(16125.123f, testNumStack.pop(), 
          "Checks if Stack was pushed then popped correctly.");
      assertEquals(123412.421f, testNumStack.pop(), 
          "Checks if Stack was pushed then popped correctly.");
      
  }
  @Test
  public void testIsEmpty() {
    // Test 1 Check if correct value is given when given an empty set.
    assertEquals(true ,testNumStack.isEmpty(), "Checks is Stack is Empty.");
    // Test 2 Check if correct value is given when an entry is pushed into the Stack.
    testNumStack.push(123412.421f);
    assertEquals(false ,testNumStack.isEmpty(), "Checks is Stack is Empty.");
  }
  
  @Test
  public void pushThenPopThenCheckEmpty() {
    //Test 1 Check if correct value is given after Stack is Pushed, Popped and then asked if Empty.
    testNumStack.push(161235.531f);
    testNumStack.pop();
    assertEquals(true, testNumStack.isEmpty(), "Checks if Stack is Empty after pop.");
  }
  
  @Test
  public void testTop() {
    // Test 1 Checking if correct value is given when top method is called.
    testNumStack.push(524.12f);
    assertEquals(524.12f, testNumStack.top(), "Checks correct Entry is at the top of the Stack");
    assertEquals(524.12f, testNumStack.top(), 
        "Checking twice as Entry should not be removed when top method is called");
  }
  
}

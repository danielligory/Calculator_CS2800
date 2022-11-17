package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
  
  

}

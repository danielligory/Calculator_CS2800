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
  }
  
  public void testPush() {
    // Test 1 Check if Stack is created properly.
    assertEquals(0, testStrStack.size(), "Check if Stack is working, size of Stack should be 0");
    // Test 2 Check if one entry was pushed properly.
    testStrStack.push("test");
    assertEquals(1, testStrStack.size(), "Check if size of Stack is size 1");
    // Test 3 Check if two entries was pushed properly.
    testStrStack.push("test");
    assertEquals(2, testStrStack.size(), "Check if size of Stack is size 2");
    // Test 4 Check if 36 entries was pushed properly.
    int i = 0;
    while (i != 34) {
      testStrStack.push("test");
      i ++;
    }
    assertEquals(36, testStrStack.size(), "Check is size of Stack is 36");
  }
  
  @Test
  public void testPop() {
    // Test 1 Check if EmptyStackException is thrown when pop is called on Empty Stack.
    assertThrows(EmptyStackException.class, () -> testStrStack.pop(), 
        "Should not be able to pop from an Empty Stack."); 
    }
  
  @Test
  public void pushThenPop() {
    // Test 1 Check if correct value is popped when one Entry is pushed.
    testStrStack.push("test");
    assertEquals("test", testStrStack.pop(), 
        "Checks if Stack was pushed then popped correctly.");
  }

  @Test
  public void pushManyThenPop() {
    // Test 1 Check if correct value is popped when multiple Entries are pushed.
    testStrStack.push("test");
    testStrStack.push("test1");
    testStrStack.push("test2");
    
    assertEquals("test2", testStrStack.pop(), 
        "Checks if Stack was pushed then popped correctly.");
  }
  
  @Test
  public void pushManyThenPopMany() {
   // Test 1 Check if correct value is popped when multiple Entries are pushed.
      testStrStack.push("test");
      testStrStack.push("test1");
      testStrStack.push("test2");
      
      assertEquals("test2", testStrStack.pop(), 
          "Checks if Stack was pushed then popped correctly.");
      assertEquals("test1", testStrStack.pop(), 
          "Checks if Stack was pushed then popped correctly.");
      assertEquals("test", testStrStack.pop(), 
          "Checks if Stack was pushed then popped correctly.");
      
  }
  @Test
  public void testIsEmpty() {
    // Test 1 Check if correct value is given when given an empty set.
    assertEquals(true ,testStrStack.isEmpty(), "Checks is Stack is Empty.");
    // Test 2 Check if correct value is given when an entry is pushed into the Stack.
    testStrStack.push("test");
    assertEquals(false ,testStrStack.isEmpty(), "Checks is Stack is Empty.");
  }
  
  @Test
  public void pushThenPopThenCheckEmpty() {
    //Test 1 Check if correct value is given after Stack is Pushed, Popped and then asked if Empty.
    testStrStack.push("test");
    testStrStack.pop();
    assertEquals(true, testStrStack.isEmpty(), "Checks if Stack is Empty after pop.");
  }
  
  @Test
  public void testTop() {
    // Test 1 Checking if correct value is given when top method is called.
    testStrStack.push("test");
    assertEquals("test", testStrStack.top(), "Checks correct Entry is at the top of the Stack");
    assertEquals("test", testStrStack.top(), 
        "Checking twice as Entry should not be removed when top method is called");
  }
  
  
  
}  
  
  
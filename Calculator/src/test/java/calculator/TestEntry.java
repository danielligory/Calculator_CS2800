package calculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
//import calculator.Entry;

class TestEntry {

  @Test
  void testContructor1(){
    // Test 1 Check if constructor constructed properly.
    Entry e = new Entry(100f);
    assertEquals(100f, e.getValue());
    // Test 2 Check if constructor constructed a longer float properly.
    Entry e1 = new Entry(1230090213901239f);
    assertEquals(1230090213901239f, e1.getValue());

  }
  
  @Test
  void testContructor2(){
    // Test 1 Check if constructor constructed properly.
    Entry e = new Entry(Symbol.LEFT_BRACKET);
    assertEquals(Symbol.LEFT_BRACKET, e.getSymbol());
    
  }
  
}


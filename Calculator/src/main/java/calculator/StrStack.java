package calculator;

/**
 * The Shunting algorithm requires reversing an expression in order to evaluate an expression in
 * order to evaluate left to right - so we provide a facade to hide details.
 * 
 * @author Daniel Ligory
 * 
 */

public class StrStack {
  private int size;
  private Stack strStack = new Stack();

  /**
   * Adds a new Entry to Stack.
   * 
   * @param str argument that is added to Stack
   */
  public void push(String str) {
    strStack.push(new Entry(str));
    size++;
  }

  /**
   * How many Entry's in the Stack.
   * 
   * @return the size of the Entry Stack
   */
  public int size() {
    return size;
  }

  /**
   * Returns (and removes) newest Entry.
   * 
   * @return newest Entry from Stack
   */
  public String pop() {
    return strStack.pop().getString();
  }

  /**
   * Returns boolean if Stack is Empty or not.
   * 
   * @return true or false
   */
  public boolean isEmpty() {
    if (strStack.size() == 0) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Returns (but keeps) newest Entry.
   * 
   * @return newest Entry in Stack
   */
  public String top() {
    return strStack.top().getString();
  }

}

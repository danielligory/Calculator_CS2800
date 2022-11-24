package calculator;

public class StrStack {
  private int size;
  private Stack strStack = new Stack();
  
  /**
   * Adds a new Entry to Stack.
   * @param i argument that is added to Stack
   */
  public void push(String str) {
    strStack.push(new Entry (str));
    size ++;
  }

  public int size() {
    return size;
  }
  
  /**
   * Returns (and removes) newest Entry.
   * @return newest Entry
   */
  public String pop() {
    return strStack.pop().getString();
  }

  /**
   * Returns if Stack is Empty or not.
   * @return true or false
   */
  public boolean isEmpty() {
    if (strStack.size() == 0) {
      return true;
    }else {
      return false;
    }
  }
  
  /**
   * Returns (but keeps) newest Entry.
   * @return newest Entry in Stack
   */
  public String top() {
    return strStack.top().getString();
  }
  
}

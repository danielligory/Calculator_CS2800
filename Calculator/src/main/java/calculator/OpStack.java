package calculator;

public class OpStack {
  private int size;
  private Stack opStack = new Stack();

  /**
   * Adds a new Entry to Stack.
   * @param i argument that is added to Stack
   */
  public void push(Symbol i) {
    opStack.push(new Entry (i));
    size ++;
    
  }
  
  /**
   * Used to tell us how many entries are in the Stack.
   * @return the size
   */
  public int size() {
    return size;
  }

  /**
   * Returns (and removes) newest Entry.
   * @return newest Entry
   */
  public Symbol pop() {
    return opStack.pop().getSymbol();
  }
  
  /**
   * Returns if Stack is Empty or not.
   * @return true or false
   */
  public boolean isEmpty() {
    if (opStack.size() == 0) {
      return true;
    }else {
      return false;
    }
  }
  
  /**
   * Returns (but keeps) newest Entry.
   * @return newest Entry in Stack
   */
  public Symbol top() {
    return opStack.top().getSymbol();
  }
  

}

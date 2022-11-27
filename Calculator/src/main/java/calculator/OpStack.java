package calculator;

/**
 * Since the Shunting algorithm only uses a Stack of symbols we provide a facade to hide details.
 * 
 * @author Daniel Ligory
 * 
 */

public class OpStack {
  private int size;
  private Stack opStack = new Stack();

  /**
   * Adds a new Entry to Stack.
   * 
   * @param i argument that is added to Stack
   */
  public void push(Symbol i) {
    opStack.push(new Entry(i));
    size++;

  }

  /**
   * Used to tell us how many entries are in the Stack.
   * 
   * @return the size of the Entry Stack
   */
  public int size() {
    return size;
  }

  /**
   * Returns (and removes) newest Entry.
   *
   * @return newest Entry in the Stack
   */
  public Symbol pop() {
    return opStack.pop().getSymbol();
  }

  /**
   * Returns boolean if Stack is Empty or not.
   * 
   * @return true or false
   */
  public boolean isEmpty() {
    if (opStack.size() == 0) {
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
  public Symbol top() {
    return opStack.top().getSymbol();
  }


}

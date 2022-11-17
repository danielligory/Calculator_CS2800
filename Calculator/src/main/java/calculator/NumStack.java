package calculator;


/**
 * Since reverse Polish Evaluation only uses a Stack of numeric values we provide a facade to hide details.
 * @author Daniel Ligory
 *
 */

public class NumStack {
  private int size;
  private Stack numStack = new Stack();

  /**
   * Adds a new Entry to Stack.
   * @param i argument that is added to Stack
   */
  public void push(float i) {
    numStack.push(new Entry (i));
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
   * @return newest Entry.
   */
  public float pop() {
    return numStack.pop().getValue();
  }
  
  
  
  
  
}


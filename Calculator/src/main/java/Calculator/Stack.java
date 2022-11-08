package Calculator;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * This class represents a Stack of Entry values.
 * 
 * @author Daniel Ligory
 * 
 */

public class Stack {
  private int size;
  private ArrayList<Entry> entries = new ArrayList<Entry>();

  /**
   * Adds a new Entry to the Stack.
   * 
   * @param i entry to be added
   */
  public void push(Entry i) {
    entries.add(i);
    size = size + 1;
  }

  /**
   * Returns (and removes) newest Entry.
   * 
   * @return the removed Entry
   */
  public Entry pop() {
    if (this.entries.isEmpty()) {
      throw new EmptyStackException();
    }
    Entry temp = entries.get(size - 1);
    entries.remove(size - 1);
    size = size - 1;
    return temp;
  }

  /**
   * Return (but keeps) newest Entry.
   * 
   * @return newest Entry
   */
  public Entry top() {
    if (entries.isEmpty()) {
      throw new EmptyStackException();
    }
    return entries.get(size - 1);
  }

  /**
   * How many Entry's in the Stack.
   * 
   * @return the size of the Entry
   */
  public int size() {
    return size;
  }

}

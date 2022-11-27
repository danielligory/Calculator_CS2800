package calculator;

/**
 * This class represents a Stack of Entry values.
 * 
 * @author Daniel Ligory
 * 
 */

import java.util.ArrayList;
import java.util.EmptyStackException;


public class Stack {
  private int size;
  private ArrayList<Entry> entries = new ArrayList<Entry>();

  /**
   * Adds a new Entry to the Stack.
   * 
   * @param i entry to be added to Stack
   */
  public void push(Entry i) {
    entries.add(i);
    size = size + 1;
  }

  /**
   * Returns (and removes) newest Entry.
   * 
   * @return the removed Entry from Stack
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
   * @return newest Entry from Stack
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
   * @return the size of the Entry Stack
   */
  public int size() {
    return size;
  }

}

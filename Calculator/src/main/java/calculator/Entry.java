package calculator;

/**
 * Values stored in a Stack.
 * 
 * @author Daniel Ligory
 * 
 */

public class Entry {

  private float number;
  private Symbol other;
  private String str;
  private Type type;

  /**
   * A constructor assigning the value to number.
   *
   * @param value number input by user
   */
  public Entry(float value) {
    this.number = value;
  }

  /**
   * A constructor assigning the value to other.
   *
   * @param which symbol input by user
   */
  public Entry(Symbol which) {
    this.other = which;
  }

  /**
   * @return the type
   */
  public Type getType() {
    return type;
  }

  /**
   * @return the str
   * @throws bad type Exception
   */
  public String getString() throws Exception {
    if (this.equals(null)) {
      throw new Exception("Bad Type");
    }
    return this.str;
  }

  /**
   * @return the other
   * @throws bad type Exception
   */
  public Symbol getSymbol() throws Exception {
    if (this.equals(null)) {
      throw new Exception("Bad Type");
    }
    return this.other;
  }

  /**
   * @return the number
   * @throws bad type Exception
   */
  public float getValue() throws Exception {
    if (this.equals(null)) {
      throw new Exception("Bad Type");
    }
    return this.number;
  }



}

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
  private Type type;
  private String str;

  /**
   * A constructor assigning the value to number.
   *
   * @param value number input by user
   */
  public Entry(float value) {
    number = value;
  }


  /**
   * @return the number
   * @throws bad type Exception
   */
  public float getValue(){
    return this.number;
  }

  /**
   * A constructor assigning the value to other.
   *
   * @param which symbol input by user
   */
  public Entry(Symbol which) {
    other = which;
  }
  
  /**
   * @return the other
   * @throws bad type Exception
   */
  public Symbol getSymbol(){
    return this.other;
  }


  /**
   * @return the str
   * @throws bad type Exception
   */
  public String getString(){
    return str;
  }

  /**
   * @return the type
   */
  public Type getType() {
    return type;
  }
  
  /**
   * A constructor assigning the value to str.
   *
   * @param string input by user
   */
  public Entry(String string) {
    str = string;
  }


}

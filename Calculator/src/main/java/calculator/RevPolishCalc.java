package calculator;

import java.util.ArrayList;

public class RevPolishCalc {
  private NumStack values = new NumStack();
  private ArrayList<String> revPolishInput = new ArrayList<String>();
  int count = 0;
  int i = 0;

  /**
   * Splits an input string into an array of substrings, separated by whitespace.
   * 
   * @param input the input string to split
   * @return a list of substrings from the input string
   */
  public ArrayList<String> makeArray(String input) {
    while (i != input.length()) {
      if (input.substring(i, i + 1).isBlank()) {
        revPolishInput.add(input.substring(count, i));
        i++;
        count = i;
      } else {
        i++;
      }
    }
    revPolishInput.add(input.substring(input.length() - 1, input.length())); // adds the last value
                                                                             // the String
    return revPolishInput;
  }

  /**
   * Performs the operation at the top of the operator stack on the top two values of the values
   * stack, and pushes the result onto the values stack.
   *
   * @param input the operator to perform, as a string ("+", "-", "*", or "/")
   */
  public void operationStack(String input) {
    float value1;
    float value2;
    value2 = values.pop();
    value1 = values.pop();
    if (input.equals("+")) {
      values.push(value1 + value2);
    } else if (input.equals("-")) {
      values.push(value1 - value2);
    } else if (input.equals("*")) {
      values.push(value1 * value2);
    } else if (input.equals("/")) {
      values.push(value1 / value2);
    }
  }

  /**
   * Evaluates the given Reverse Polish notation expression and returns the result.
   *
   * @param what the Reverse Polish notation expression to evaluate, as a string
   * @return the result of the evaluation
   */
  public float evaluate(String what) {
    int y = 0;
    revPolishInput = makeArray(what);
    while (y != revPolishInput.size()) {
      if (!(revPolishInput.get(y).equals("+") || revPolishInput.get(y).equals("-")
          || revPolishInput.get(y).equals("*") || revPolishInput.get(y).equals("/"))) {
        values.push(Float.valueOf(revPolishInput.get(y)));
        y++;
      } else {
        operationStack(revPolishInput.get(y));
        y++;
      }
    }
    return values.pop();
  }


}

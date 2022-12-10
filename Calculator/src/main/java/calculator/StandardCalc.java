package calculator;

import java.util.ArrayList;

public class StandardCalc {
  private NumStack numValues = new NumStack();
  private OpStack opValues = new OpStack();
  private OpStack opValues2 = new OpStack();
  private ArrayList<String> standardCalcInput = new ArrayList<String>();
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
        standardCalcInput.add(input.substring(count, i));
        i++;
        count = i;
      } else {
        i++;
      }
    }
    standardCalcInput.add(input.substring(input.length() - 1, input.length()));
    return standardCalcInput;
  }

  /**
   * Compares the precedence of two operators in an arithmetic expression.
   * 
   * @param symbol1 the first operator to compare
   * @param symbol2 the second operator to compare
   * @return true if the first operator has higher or equal precedence than the second operator,
   *         false otherwise
   */
  public boolean greaterOperator(OpStack symbol1, OpStack symbol2) {
    if (symbol2.isEmpty() || symbol2.top() == Symbol.LEFT_BRACKET
        || symbol2.top() == Symbol.RIGHT_BRACKET) {
      return false;
    } else if ((symbol1.top() == Symbol.TIMES || symbol1.top() == Symbol.DIVIDE)
        && (symbol2.top() == Symbol.PLUS || symbol2.top() == Symbol.MINUS)) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * Pushes the given operator to the operator stack.
   *
   * @param value the operator to push, as a string ("+", "-", "*", or "/")
   */
  public void pushOperator(String value) {
    switch (value) {
      case "+":
        opValues.push(Symbol.PLUS);
        break;
      case "-":
        opValues.push(Symbol.MINUS);
        break;
      case "*":
        opValues.push(Symbol.TIMES);
        break;
      case "/":
        opValues.push(Symbol.DIVIDE);
        break;
    }
  }

  /**
   * Performs an arithmetic operation on two values using the given operator.
   * 
   * @param value1 the first operand
   * @param value2 the second operand
   * @return the result of the arithmetic operation
   */
  public void calcOperator(float value1, float value2) {
    switch (opValues.pop()) {
      case DIVIDE:
        numValues.push(value1 / value2);
        break;
      case MINUS:
        numValues.push(value1 - value2);
        break;
      case PLUS:
        numValues.push(value1 + value2);
        break;
      case TIMES:
        numValues.push(value1 * value2);
        break;
      default:
        break;
    }

  }

  /**
   * Evaluates an arithmetic expression and returns the result.
   * 
   * @param what the arithmetic expression to evaluate
   * @return the result of the evaluation
   */
  public float evaluate(String what) {
    int y = 0;
    standardCalcInput = makeArray(what);
    while (y != standardCalcInput.size()) {

      if (standardCalcInput.get(y).equals("(")) {
        opValues.push(Symbol.LEFT_BRACKET);
        y++;

      } else if (standardCalcInput.get(y).equals(")")) {
        while (opValues.top() != Symbol.LEFT_BRACKET) {
          float value2 = numValues.pop();
          float value1 = numValues.pop();
          calcOperator(value1, value2);
        }
        opValues.pop(); // Pops the remaining left bracket.
        y++;

      } else if (standardCalcInput.get(y).equals("+") || standardCalcInput.get(y).equals("-")
          || standardCalcInput.get(y).equals("*") || standardCalcInput.get(y).equals("/")) {
        pushOperator(standardCalcInput.get(y));
        while (!(opValues.isEmpty()) && greaterOperator(opValues, opValues2)) {
          float value2 = numValues.pop();
          float value1 = numValues.pop();
          calcOperator(value1, value2);
          opValues.push(opValues2.pop());
        }
        y++;

      } else {
        numValues.push(Float.valueOf(standardCalcInput.get(y)));
        y++;
      }
    }
    while (!(opValues.isEmpty())) {
      float value2 = numValues.pop();
      float value1 = numValues.pop();
      calcOperator(value1, value2);
    }

    return numValues.top();
  }

}

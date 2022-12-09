package calculator;

import java.util.ArrayList;

public class RevPolishCalc {
  private NumStack values = new NumStack();
  private ArrayList<String> revPolishInput = new ArrayList<String>();
  int count = 0;
  int i = 0;


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
    revPolishInput.add(input.substring(input.length() - 1, input.length())); // adds the last value the String
    return revPolishInput;
  }


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

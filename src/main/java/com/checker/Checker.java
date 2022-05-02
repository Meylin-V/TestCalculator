package com.checker;

import java.util.Stack;

import static com.calculator.Constants.CLOSED_BRACKET;
import static com.calculator.Constants.OPENED_BRACKET;

public class Checker {
  String formula;
  String errorMessage;

  public Checker(String formula) {
    this.formula = formula;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public boolean checkBrackets() {
    Stack<String> brackets = new Stack<>();
    for (int i = 0; i < formula.length(); i++) {
      String symbol = String.valueOf(formula.charAt(i));
      if (OPENED_BRACKET.equals(symbol)) {
        brackets.push(symbol);
      } else if (CLOSED_BRACKET.equals(symbol)) {
        if (brackets.isEmpty()) {
          errorMessage = "You put incorrect brackets!";
          return false;
        }
        brackets.pop();
      }
    }
    boolean result = brackets.isEmpty();
    errorMessage = !result ? "You put incorrect brackets!" : "";
    return result;
  }

  public boolean checkSymbols() {
    boolean result = formula.matches("[\\d-/+*^.()]+");
    errorMessage = !result ? "You put incorrect symbols!" : "";
    return result;
  }

  public boolean checkOperators() {
    boolean result = !formula.matches(".+[-/+*^][/+*^].+");
    errorMessage = !result ? "You put incorrect operands!" : "";
    return result;
  }
}

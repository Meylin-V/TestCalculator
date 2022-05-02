package com.calculator;

import java.util.Stack;

import static com.calculator.Constants.*;

public class Calculator {
  String formula;

  public Calculator(String formula) {
    this.formula = formula;
  }

  public double calculate() {
    if (formula.isEmpty()) {
      System.out.println("You doesn't put formula");
      return 0;
    }

    Stack<Double> numbers = new Stack<>();
    Stack<String> operations = new Stack<>();
    StringBuilder number = new StringBuilder(EMPTY_STRING);

    for (int i = 0; i < formula.length(); i++) {
      String symbol = String.valueOf(formula.charAt(i));
      if (!number.toString().equals(EMPTY_STRING) && !isNumber(symbol)) {
        numbers.add(makeNumber(number.toString()));
        number = new StringBuilder(EMPTY_STRING);
      }
      if (OPERANDS.contains(symbol)) {
        if (isUnaryMinus(i)) {
          number.append(symbol);
        } else {
          checkOperand(symbol, operations, numbers);
        }
      } else if (OPENED_BRACKET.equals(symbol)) {
        operations.add(symbol);
      } else if (CLOSED_BRACKET.equals(symbol)) {
        if (!operations.peek().equals(OPENED_BRACKET)) {
          numbers.add(calculateAction(operations.pop(), numbers));
        }
        operations.pop();
      } else {
        number.append(symbol);
        if (i == formula.length() - 1) {
          numbers.add(makeNumber(number.toString()));
        }
      }
    }
    if (operations.isEmpty()) {
      return numbers.pop();
    }
    double result = calculateAction(operations.pop(), numbers);
    while (!operations.isEmpty()) {
      numbers.add(result);
      result = calculateAction(operations.pop(), numbers);
    }
    return result;
  }

  private void checkOperand(String operand, Stack<String> operations, Stack<Double> numbers) {
    if (operations.isEmpty() || hasHigherPriority(operand, operations)) {
      operations.add(operand);
    } else {
      numbers.add(calculateAction(operations.pop(), numbers));
      checkOperand(operand, operations, numbers);
    }
  }

  private boolean isUnaryMinus(int i) {
    return i == 0 && formula.charAt(i) == '-'
            || OPERANDS.contains(String.valueOf(formula.charAt(i-1))) && formula.charAt(i) == '-';
  }

  private Boolean isNumber(String input) {
    return NUMBERS.contains(input);
  }

  private double makeNumber(String number) {
    return Double.parseDouble(number);
  }

  private double calculateAction(String operand, Stack<Double> numbers) {
    double second = getNumber(numbers);
    double first = getNumber(numbers);
    return switch (operand) {
      case "^" -> Math.pow(first, second);
      case "*" -> first * second;
      case "/" -> first / second;
      case "+" -> first + second;
      case "-" -> first - second;
      default -> 0;
    };
  }

  private double getNumber(Stack<Double> numbers) {
    return numbers.pop();
  }

  private boolean hasHigherPriority(String operand, Stack<String> operations) {
    return PRIORITY_MAP.get(operand) > PRIORITY_MAP.get(operations.peek());
  }
}

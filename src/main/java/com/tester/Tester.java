package com.tester;

import com.calculator.Calculator;

import java.util.Map;

public class Tester {

  Map<String, Double> testCases;

  public Tester(Map<String, Double> testCases) {
    this.testCases = testCases;
  }

  public void test() {
    int trueResults = 0;
    for (Map.Entry<String, Double> testCase : testCases.entrySet()) {
      Calculator calculator = new Calculator(testCase.getKey());
      System.out.println(testCase.getKey());
      double result = calculator.calculate();
      System.out.println("Test " + testCase.getKey() + " : the result is: " + result);
      if (result == testCase.getValue()) {
        trueResults++;
        System.out.println("TRUE");
      } else {
        System.err.println("False");
      }
    }
    if (trueResults == testCases.size()) {
      System.out.println("All tests PASS");
    }
  }
}

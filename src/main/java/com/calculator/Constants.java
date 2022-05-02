package com.calculator;

import java.util.Map;

public class Constants {
  public static final String NUMERICS = "0123456789";

  public static final String PUNCTUATION_MARK = ".";

  public static final String NUMBERS = NUMERICS + PUNCTUATION_MARK;

  public static final String OPERANDS = "+-*/^";

  public static final String OPENED_BRACKET = "(";

  public static final String CLOSED_BRACKET = ")";

  public static final String EMPTY_STRING = "";

  public static final Map<String, Integer> PRIORITY_MAP = Map.ofEntries(
          Map.entry("+", 1),
          Map.entry("-", 1),
          Map.entry("*", 2),
          Map.entry("/", 2),
          Map.entry("^", 3),
          Map.entry("(", 0)
  );
}
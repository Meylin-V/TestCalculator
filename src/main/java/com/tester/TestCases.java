package com.tester;

import java.util.Map;

public class TestCases {
  public static final Map<String, Double> TEST_CASES = Map.ofEntries(
          Map.entry("(3+4+5+(2+6+1)+1+(2+3))", 27.0),
          Map.entry("1+2+3+4", 10.0),
          Map.entry("(((1+2)+3)+4)+2", 12.0),
          Map.entry("1+(2+(3+4))+2", 12.0),
          Map.entry("9-5", 4.0),
          Map.entry("9-5-1-2", 1.0),
          Map.entry("9-4-(5-2)", 2.0),
          Map.entry("9-1-(5+2)", 1.0),
          Map.entry("(3+4-5+(2+6-1)-1-(2+3))", 3.0),
          Map.entry("9*5", 45.0),
          Map.entry("1+9*5", 46.0),
          Map.entry("2*3+4", 10.0),
          Map.entry("2+5*4", 22.0),
          Map.entry("2+(5*4)", 22.0),
          Map.entry("(4)", 4.0),
          Map.entry("5", 5.0),
          Map.entry("(2+3)*2", 10.0),
          Map.entry("2*(5+4)", 18.0),
          Map.entry("2*(5*4)", 40.0),
          Map.entry("3*2*(5+4+2)", 66.0),
          Map.entry("", 0.0),
          Map.entry("2^(5-2)", 8.0),
          Map.entry("2.7-3.7", -1.0),
          Map.entry("5.2+1*(0.2+0.6)", 6.0),
          Map.entry("2*-2", -4.0),
          Map.entry("5/2.5", 2.0));
}

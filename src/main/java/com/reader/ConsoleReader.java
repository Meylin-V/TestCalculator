package com.reader;

import java.util.Scanner;

public class ConsoleReader {
  public String readFormula() {
    Scanner in = new Scanner(System.in);
    System.out.print("Please, put your formula! ");
    String formula = in.nextLine();
    return formula.replaceAll("\\s+", "");
  }
}

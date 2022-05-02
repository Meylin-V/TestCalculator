package com;

import com.calculator.Calculator;
import com.checker.Checker;
import com.csv.CSVFileEditor;
import com.csv.CSVFileWriter;
import com.csv.CsvFileReader;
import com.datamapper.FileDataMapper;
import com.exception.DataNotFoundException;
import com.reader.ConsoleReader;

import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    //Tester tester = new Tester(TEST_CASES);
    //tester.test();
    String filePath = "src/main/java/com/results.csv";

    /* Read formula */
    String formula = new ConsoleReader().readFormula();
    System.out.println("\n" + "You put the next formula: " + formula);

    Checker checker = new Checker(formula);
    /* Check formula and calculate */
    if (checker.checkBrackets() && checker.checkSymbols() && checker.checkOperators()) {
      Calculator calculator = new Calculator(formula);
      double result = calculator.calculate();
      System.out.println("The result is: " + result);
      writeCSV(formula, result, filePath);
    } else {
      System.out.println(checker.getErrorMessage());
    }

    /* Read and print CSV-file with results */
    CsvFileReader csvFileReader = new CsvFileReader(filePath);
    List<String[]> list = csvFileReader.readFileContent();
    for (String[] s : list) {
      System.out.println(Arrays.asList(s));
    }

    /* Editing of formula in CSV-file */
    editResults(filePath);

    /* Find results in CSVFile*/
    findResults(filePath);
  }

  private static void writeCSV(String formula, double result, String filePath) {
    CSVFileWriter csvFileWriter = new CSVFileWriter(filePath, formula, result);
    csvFileWriter.writeOneLineCSV();
  }

  private static void editResults(String filePath) {
    CSVFileEditor editor = new CSVFileEditor(filePath);
    editor.replaceFormula(0, "2-1", 1.0);
  }

  private static void findResults(String filePath) {
    FileDataMapper fileDataMapper = new FileDataMapper(filePath);
    try {
      System.out.println("Find equals to 4: " + fileDataMapper.findEqual("4"));
      System.out.println("Find bigger then 5: " + fileDataMapper.findBigger("5"));
      System.out.println("Find smaller then 6: " + fileDataMapper.findSmaller("6"));
    } catch (DataNotFoundException e) {
      e.printStackTrace();
    }
  }
}
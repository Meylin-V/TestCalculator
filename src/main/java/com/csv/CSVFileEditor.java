package com.csv;

import java.util.List;

public class CSVFileEditor {
  private final String filePath;

  public CSVFileEditor(String filePath) {
    this.filePath = filePath;
  }

  public void replaceFormula(int index, String formula, double result) {
    List<String[]> fileContent = readFileContent();
    try {
      fileContent.set(index, new String[]{formula, String.valueOf(result)});
      CSVFileWriter csvFileWriter = new CSVFileWriter(filePath, formula, result);
      csvFileWriter.writeCSV(fileContent);
    } catch (IndexOutOfBoundsException e) {
      System.err.println("You put non-existent index!");
    }
  }

  private List<String[]> readFileContent() {
    CsvFileReader csvFileReader = new CsvFileReader(filePath);
    return csvFileReader.readFileContent();
  }
}

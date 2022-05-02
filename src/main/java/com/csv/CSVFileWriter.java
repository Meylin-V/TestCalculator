package com.csv;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVFileWriter {
  private final String path;
  private final String formula;
  private final double result;

  public CSVFileWriter(String path, String formula, double result) {
    this.path = path;
    this.formula = formula;
    this.result = result;
  }

  public void writeOneLineCSV() {
    try {
      CSVWriter writer = new CSVWriter(new FileWriter(path, true));
      String[] record = new String[]{formula, String.valueOf(result)};
      writer.writeNext(record);
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void writeCSV(List<String[]> fileContent) {
    try {
      CSVWriter writer = new CSVWriter(new FileWriter(path));
      for (String[] oneLine : fileContent) {
        writer.writeNext(oneLine);
      }
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

package com.csv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReader {
  private final String path;

  public CsvFileReader(String path) {
    this.path = path;
  }

  public List<String[]> readFileContent() {
    List<String[]> fileContent = new ArrayList<>();
    try (CSVReader reader = new CSVReader(new FileReader(path))) {
      String[] nextLine;
      while ((nextLine = reader.readNext()) != null) {
          fileContent.add(nextLine);
      }
    } catch (CsvValidationException | IOException e) {
      e.printStackTrace();
    }
    return fileContent;
  }
}

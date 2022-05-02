package com.datamapper;

import com.csv.CsvFileReader;
import com.exception.DataNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class FileDataMapper implements DataMapper {
  private final String filePath;

  public FileDataMapper(String filePath) {
    this.filePath = filePath;
  }

  @Override
  public List<String> findEqual(String result) throws DataNotFoundException {
    List<String[]> fileContent = readFileContent();
    List<String> formulas = new ArrayList<>();
    for (String[] oneLine : fileContent) {
      if (Double.parseDouble(oneLine[1]) == Double.parseDouble(result)) {
        formulas.add(oneLine[0]);
      }
    }
    if (formulas.size() != 0) {
      return formulas;
    }
    throw new DataNotFoundException("There are no formulas which give result: " + result);
  }

  @Override
  public List<String> findBigger(String result) throws DataNotFoundException {
    List<String[]> fileContent = readFileContent();
    List<String> formulas = new ArrayList<>();
    for (String[] oneLine : fileContent) {
      if (Double.parseDouble(oneLine[1]) > Double.parseDouble(result)) {
        formulas.add(oneLine[0]);
      }
    }
    if (formulas.size() != 0) {
      return formulas;
    }
    throw new DataNotFoundException("There are no formulas which give result bigger than: " + result);
  }

  @Override
  public List<String> findSmaller(String result) throws DataNotFoundException {
    List<String[]> fileContent = readFileContent();
    List<String> formulas = new ArrayList<>();
    for (String[] oneLine : fileContent) {
      if (Double.parseDouble(oneLine[1]) < Double.parseDouble(result)) {
        formulas.add(oneLine[0]);
      }
    }
    if (formulas.size() != 0) {
      return formulas;
    }
    throw new DataNotFoundException("There are no formulas which give result smaller than: " + result);
  }

  private List<String[]> readFileContent() {
    CsvFileReader csvFileReader = new CsvFileReader(filePath);
    return csvFileReader.readFileContent();
  }
}

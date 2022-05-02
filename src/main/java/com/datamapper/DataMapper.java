package com.datamapper;

import com.exception.DataNotFoundException;

import java.util.List;

public interface DataMapper {
  List<String> findEqual(String result) throws DataNotFoundException;

  List<String> findBigger(String result) throws DataNotFoundException;

  List<String> findSmaller(String result) throws DataNotFoundException;
}

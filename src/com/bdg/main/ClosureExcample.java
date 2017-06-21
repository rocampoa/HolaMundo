package com.bdg.main;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by Rafael on 17/06/2017.
 */
public class ClosureExcample {

  int instanceLength;

  public Function<String, String> getStringOperation() {
    final String separator = ":";
    return target -> {
      int localLength = target.length();
      instanceLength = target.length();
      return target.toLowerCase() + separator + instanceLength + separator + localLength;
    };
  }
}

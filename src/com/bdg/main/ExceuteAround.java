package com.bdg.main;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by Rafael on 30/06/2017.
 * Ejemplo de execute-around-method pattern
 * También se incluye ejemplo de executeBefore y ExceuteAfter
 */
public class ExceuteAround {

  public int executeImperativeSquareSolution(int value) {
    long start = System.currentTimeMillis();
    int result = 0;
    try {
      result = value * value;
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    long end = System.currentTimeMillis();
    System.out.println("Duration: " + (end - start) + " - ");
    return result;
  }

  public int executeImperativeCubeSolution(int value) {
    long start = System.currentTimeMillis();
    int result = 0;
    try {
      result = value * value * value;
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    long end = System.currentTimeMillis();
    System.out.println("Duration: " + (end - start) + " - ");
    return result;
  }

  //Utilizando programación funcional para no repetir código
  public int executeDuration(Function<Integer, Integer> computation, int value) {
    long start = System.currentTimeMillis();
    int result = 0;
    try {
      result = computation.apply(value);
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    long end = System.currentTimeMillis();
    System.out.println("Duration: " + (end - start) + " - ");
    return result;
  }

  public int executeBefore(Function<Integer, Integer> beforeFunction,
                           Function<Integer, Integer> function,
                           Integer value) {
    beforeFunction.apply(value);
    return function.apply(value);
  }

  public int executeAfter(Function<Integer, Integer> function,
                          Function<Integer, Integer> afterFunction,
                          Integer value) {
    int result = function.apply(value);
    afterFunction.apply(result);
    return result;
  }


  private static int withLog(int value) {
    System.out.print("Operation logged for " + value + " - ");
    return value;
  }

  public static void main(String[] args) {
    ExceuteAround exceuteAround = new ExceuteAround();
    System.out.println(exceuteAround.executeImperativeSquareSolution(5));
    System.out.println(exceuteAround.executeImperativeCubeSolution(5));
    // Con programación funcional
    System.out.println(exceuteAround.executeDuration(x -> x * x, 5));
    System.out.println(exceuteAround.executeDuration(x -> x * x * x, 5));

    // Instead of using lambda expressions as a argument of functional methods
    Function<Integer, Integer> computeSquare = x -> x * x;
    Function<Integer, Integer> computeCube = x -> x * x * x;
    System.out.println(exceuteAround.executeDuration(computeSquare, 5));
    System.out.println(exceuteAround.executeDuration(computeCube, 5));

    System.out.println(exceuteAround.executeBefore(ExceuteAround::withLog, computeSquare, 5));
    System.out.println(exceuteAround.executeAfter(computeSquare, ExceuteAround::withLog, 5));

    //Using the execute-around with stream
    Function<Integer, Integer> computeDuration = x -> exceuteAround.executeDuration(computeSquare, x);
    Integer arr[] = {1, 2, 3, 4, 5};
    Stream<Integer> myStream = Arrays.stream(arr);
    myStream.map(computeDuration).forEach(System.out::println);
  }


}

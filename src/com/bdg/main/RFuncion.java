package com.bdg.main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by Rafael on 15/06/2017.
 * Ejemplo de retonnando un función
 */
public class RFuncion {

  enum  EmployeeType {Hourly, Salary, Sales};

  /**
   * Función que tiene el enfoque tradicional que no permite trabajar cómodamente con programación funcional
   * @param hoursWorked
   * @param payRate
   * @param type
   * @return
   */
  public static float calculatePay(int hoursWorked, float payRate, EmployeeType type) {
    switch (type) {
      case Hourly: return hoursWorked * payRate;
      case Salary: return payRate * 40;
      case Sales: return 500.0f + 0.15f * payRate;
      default: return 0.0f;
    }
  }

  public static BiFunction<Integer, Float, Float> calculatePayFunction(EmployeeType type) {
    switch (type) {
      case Hourly:
        return (hours, payRate) -> hours * payRate;
      case Salary:
        return (hours, payRate) -> 40 * payRate;
      case Sales:
        return (hours, payRate) -> 500f + 0.15f * payRate;
      default: return null;
    }
  }

  //Ejemplo de memoization hecho a mano
  private final Map<Integer, Integer> memoizationCache = new HashMap<>();

  //Ejemplo de memoization hecho a mano
  private Integer doCompueExpensiveSquare(Integer input) {
    System.out.println("Computing square");
    return input * input;
  }

  //Ejemplo de memoization hecho a mano
  public Integer computeExpensiveSquare(Integer input) {
    if (!memoizationCache.containsKey(input)) {
      memoizationCache.put(input, doCompueExpensiveSquare(input));
    }
    return  memoizationCache.get(input);
  }

  public static void main(String[] args) {
    RFuncion obj = new RFuncion();
    int hoursWorked[] = {8, 12, 8, 6, 6, 5, 6, 0};
    int totalHoursWorked = 0;

    // Enfoque tradicional
    for(int hour : hoursWorked){
      totalHoursWorked += hour;
    }
    System.out.println(totalHoursWorked);

    //Utilizando stream más corto y efeciente
    totalHoursWorked = Arrays.stream(hoursWorked).sum();
    System.out.println(totalHoursWorked);

    // Enfoque tradicional para calcular el pago
    System.out.println(calculatePay(totalHoursWorked, 15.75f, EmployeeType.Hourly));

    //Utilizando programación funcional
    System.out.println(calculatePayFunction(EmployeeType.Hourly).apply(totalHoursWorked, 15.75f));

    //First Class Function, We can easily assign a function to a variable
    BiFunction<Integer, Float, Float> calculateFunction;
    calculateFunction = calculatePayFunction(EmployeeType.Hourly);
    System.out.println(calculateFunction.apply(51, 15.75f));

    //Ejemplo de memoization hecho a mano
    System.out.println(obj.computeExpensiveSquare(4));
    System.out.println(obj.computeExpensiveSquare(4));

    //Ejemplo con un memoizer más avanzado
    Function<Integer, Integer> squareFunction = x -> {
      System.out.println("In function");
      return x * x;
    };

    Function<Integer, Integer> memoizationFunction = Memoizer.memoize(squareFunction);
    System.out.println(memoizationFunction.apply(2));
    System.out.println(memoizationFunction.apply(2));
    System.out.println(memoizationFunction.apply(2));
  }
}





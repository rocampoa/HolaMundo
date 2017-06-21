package com.bdg.main;

import java.util.function.Function;

/**
 * Created by Rafael on 18/06/2017.
 * Clase que muestra el estilo de composición de funciones antes de Java 8
 */
public class Compose {

  public interface CompositionFunction<T, R> {
    R call(T x);
  }

  public static <T, R, U> CompositionFunction<T, R> compose(final CompositionFunction<U,R> f,
                                                            final CompositionFunction<T,U> g) {
    return new CompositionFunction<T, R>() {
      public R call(T x) {
        return f.call(g.call(x));
      }
    };
  }

  public static void main(String[] args) {
    CompositionFunction<Double, Double> doubleNumber = new CompositionFunction<Double, Double>() {
      @Override
      public Double call(Double x) {
        System.out.println("Soy el doble");
        return 2 * x;
      }
    };

    CompositionFunction<Double, Double> negateNumber = new CompositionFunction<Double, Double>() {
      @Override
      public Double call(Double x) {
        System.out.println("Soy la negación");
        return -x;
      }
    };

    CompositionFunction<Double, Double> doubleThenNegate;
    doubleThenNegate = Compose.compose(doubleNumber, negateNumber);
    System.out.println(doubleThenNegate.call(5.0));

    //Al estilo Java 8 con Lambda Expresion
    //Ejemplo f(x) = (2 + x) * 3 para X = 5 el resultado es 21
    Function<Integer, Integer> baseFunction = t -> t + 2;
    Function<Integer, Integer> afterFunction = baseFunction.andThen(t -> t * 3);
    System.out.println(afterFunction.apply(5));
    //g(x) = 2 + (x * 3); para X = 5 el resultado es 17
    Function<Integer, Integer> beforeFunction = baseFunction.compose(t -> t * 3);
    System.out.println(beforeFunction.apply(5));
  }
}

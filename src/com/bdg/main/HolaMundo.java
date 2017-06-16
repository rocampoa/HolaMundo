package com.bdg.main;

import jdk.internal.org.objectweb.asm.commons.RemappingAnnotationAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by Rafael on 4/06/2017.
 */
public class HolaMundo {

  public static String processString(Function<String, String> operation, String target) {
    return operation.apply(target);
  }

  public static void main(String[] args) {
    Integer arr[] = {1, 2, 3, 4, 5};
    List<Integer> list = Arrays.asList(arr);
    list.forEach(x -> System.out.println(x));
    Function<Integer, Integer> absThenNegate = ((Function<Integer, Integer>)Math::negateExact).compose(Math::abs);
    System.out.println(absThenNegate.apply(-25));
    System.out.println(absThenNegate.apply(25));
    Function<Integer, Integer> negateThenAbs = ((Function<Integer, Integer>)Math::negateExact).andThen(Math::abs);
    System.out.println(negateThenAbs.apply(-25));
    System.out.println(negateThenAbs.apply(25));

    Random random = new Random();
    random.ints().limit(5).sorted().forEach(x -> System.out.println(x));

    Stream<Integer> stream = Stream.of(12, 52, 32, 74, 25);
    stream.map(x -> x * 2).forEach(x -> System.out.println(x));
    stream = Stream.of(12, 52, 32, 74, 25);
    stream.parallel().map(x -> x * 2).forEach(x -> System.out.println(x));

    String cadenas[] = {"uno" , "dos", "tres"};
    List<String> listCad = Arrays.asList(cadenas);
    listCad.forEach(s -> System.out.println(processString(String::toLowerCase, s)));

    List<String> numberString = Arrays.asList("12", "34", "82");
    List<Integer> numbers = new ArrayList<>();
    List<Integer> doubleNumber = new ArrayList<>();

    // Siguiendo el enfoque tradiciona iterativo
    for(String num : numberString){
      numbers.add(Integer.parseInt(num));
    }
    System.out.println("Imprimiento resultado iterativo");
    System.out.println(numbers);

    // La misma conversión utilizando stream
    numbers.clear();
    numberString.stream().forEach(s -> numbers.add(Integer.parseInt(s)));
    System.out.println("imprimiento resultado con stream");
    System.out.println(numbers);

    //Otro enfoque
    Function<List<String>, List<Integer>> singleFunction = s -> {
      numbers.clear();
      s.stream()
              .forEach(t -> numbers.add(Integer.parseInt(t)));
      return numbers;
    };

    Function<List<String>, List<Integer>> doubleFunction = s -> {
      doubleNumber.clear();
      s.stream()
              .forEach(t -> doubleNumber.add(Integer.parseInt(t) * 2));
      return doubleNumber;
    };


    // Imprimiendo los resultados
    System.out.println("imprimiendo con otro enfoque");
    System.out.println(singleFunction.apply(numberString));
    System.out.println(doubleFunction.apply(numberString));

    // usando un map
    System.out.println("Utilizando un map");
    Arrays.asList(numberString).stream().map(doubleFunction).forEach(System.out::println);

    System.out.println("Hola mundo cruel, mi primer aplicativo en IntelliJ");
  }

}
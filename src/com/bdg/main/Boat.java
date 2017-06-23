package com.bdg.main;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Rafael on 18/06/2017.
 */
public class Boat {

  private String name;
  private String country;
  private int tonnage;
  private int draft;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Boat named(String name) {
    this.name = name;
    return this;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Boat country(String country) {
    this.country = country;
    return this;
  }

  public int getTonnage() {
    return tonnage;
  }

  public void setTonnage(int tonnage) {
    this.tonnage = tonnage;
  }

  public Boat tonnage(int tonnage) {
    this.tonnage = tonnage;
    return this;
  }

  public int getDraft() {
    return draft;
  }

  public void setDraft(int draft) {
    this.draft = draft;
  }

  public Boat draft(int draft) {
    this.draft = draft;
    return this;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Name :").append(this.name).append(" Country: ").append(this.country)
       .append(" Tonnage: ").append(this.tonnage).append(" Draft: ").append(this.draft);
    return sb.toString();
  }

  public static void main(String[] args) {
    // Método tradicional
    Boat boat = new Boat();
    boat.setCountry("Panama");
    boat.setName("Albatross");
    boat.setTonnage(12000);
    boat.setDraft(25);
    System.out.println(boat);

    //Técnica de Cascading a mi se me hace Como un Builder Pattern
    BoatCascading bc = new BoatCascading();
    bc.setName("Albatros").setCountry("Panama").setTonnage(12000).setDraft(25);
    System.out.println(bc);

    //Aplicando Fluent Interfaces, essencially setter methods violate the standard Java naming conventions
    boat = new Boat();
    boat.country("Colombia").tonnage(12500).draft(35).named("Rocampo");
    System.out.println(boat);

    //Usando Fluent intefaces to hide older interfaces/classes
    FluentRandom fr = new FluentRandom();
    for (int i = 0; i < 5; i++) {
      System.out.println(fr.nextInt());
    }

    fr = new FluentRandom().asLower(5).asUpper(25).useAsSeed(35);
    for (int i = 0; i < 5; i++) {
      System.out.println(fr.nextInt());
    }

    /*
    Extending Fluent interfaces: Fluent interfaces are elegant and can be extended if needed . However, you have to be
    careful when you do this. The Key to the approach is to use generics.
    */
    SailBoat sailBoat = new SailBoat().named("Endeavor").country("United Kingdom").sails(3).tonnage(15).hulls(2);
    System.out.println(sailBoat);

    //Count distinct problem or cardinality estimation problem
    int[] numbers = {3, 6, 8,8, 4, 6, 3, 3, 5, 6, 9, 4, 3, 6};

    //Encontrar los distintos enfoque tradicional
    Set<Integer> numberSet = new HashSet<>();
    for (int number : numbers) {
      numberSet.add(number);
    }
    int total = 0;
    for (int number : numberSet) {
      total += number;
    }
    System.out.println("Tradicional: " + total);

    //Usando stream
    total = Arrays.stream(numbers).distinct().sum();
    System.out.println("Con Stream: " + total);

    //infinite stream
    IntStream.iterate(0, n -> n + 1).limit(10).forEach(System.out::println);

    IntStream.iterate(0, n -> n + 1).filter(n -> n > 10 && n < 100)
            .limit(10).forEach(n -> System.out.print(n + " "));

    //OJO! ejemplo en el que nunca para el stream porque el límite nunca es alcanzado
    /*IntStream.iterate(0, n-> (n + 1) % 2)
            .distinct()
            .limit(10)
            .forEach(System.out::println);*/

    String[] subject = {"cat", "dog", "monkey", "bat"};
    String[] verb = {"chased", "ate", "lost", "swatted"};
    String[] object = {"ball", "rat", "doughnut", "tamale"};
    Random random = new Random();

    Stream.iterate("", m -> subject[random.nextInt(3)]
                                  + " " + verb[random.nextInt(3)]
                                  + " " + object[random.nextInt(3)])
                  .limit(5)
                  .forEach(System.out::println);

    /*
    Se obtiene el error local variables referenced from a lambda expression must be final or effectively final,
    se viola el principio de que no se puede modificar variables externas
    int number = 0;
    Stream.generate(() -> number ++).limit(5).forEach(System.out::println);*/

    // Se puede solucionar haciendo referencia a un método
    Supplier<Double> randomSupplier = Math::random;
    System.out.println();
    Stream.generate(randomSupplier).limit(4).forEach(System.out::println);

    //Flitros sobre stream
    String[] animals = {"cats", "dog", "ox", "bats", "horses", "mule"};
    Stream<String> animalStream = Arrays.stream(animals);
    animalStream.filter(x -> !x.matches(".*s$"))
                 .sorted()
            .forEach(System.out::println);

    Rectangle[] rectangles = {
            new Rectangle(10, 10, 50, 75),
            new Rectangle(30, 40, 30, 45),
            new Rectangle(110, 70, 70, 15),
            new Rectangle(50, 10, 45, 35)
    };

    Stream<Rectangle> srectangle = Arrays.stream(rectangles);
    srectangle.filter(r -> r.getX() > 10).forEach(System.out::println);

    IntStream ints = Arrays.stream(numbers);
    ints.sorted().forEach(n -> System.out.print(n + " "));

    //mapping operations
    //Enfoque iterativo
    total = 0;
    for (Rectangle rectangle: rectangles) {
      rectangle.scale(0.25);
      total += rectangle.getArea();
    }
    System.out.println(total);

    srectangle = Arrays.stream(rectangles);
    total = srectangle.map(r -> r.scale(0.25)).mapToInt(Rectangle::getArea).sum();
    System.out.println(total);

    System.out.println("-----------------------");

    //Reduce operation
    srectangle = Arrays.stream(rectangles);
    total = srectangle
            .map(r -> r.scale(0.25))
            .mapToInt(Rectangle::getArea)
            .reduce(0,(r, s) -> {
              System.out.println(r + " - " + s);
            return r + s;});
    System.out.println(total);

    //Using Flatmap method es útil para contatenar
    List<Rectangle> list1 = Arrays.asList(
            new Rectangle(10, 10, 20, 20),
            new Rectangle(10, 20, 30, 40),
            new Rectangle(40, 30, 20, 20));
    List<Rectangle> list2 = Arrays.asList(
            new Rectangle(50, 50, 30, 30),
            new Rectangle(60, 60, 20, 20));
    Stream<Rectangle> list1Stream = list1.stream();
    Stream<Rectangle> list2Stream = list2.stream();

    //Concat method combined two stream but did not modify elements of either stream
    Stream<Rectangle> concatenatedStream = Stream.concat(list1Stream, list2Stream);
    concatenatedStream.forEach(System.out::println);

    //flatMap method also performs a concatenation type operation. Like the concat method, it returns a Stream object. However, it can also modify the stream.
    List<List<Rectangle>> rectangleLists = Arrays.asList(
            Arrays.asList(new Rectangle(10, 10, 20, 20),
                    new Rectangle(10, 20, 30, 40),
                    new Rectangle(40, 30, 20, 20)),
            Arrays.asList(new Rectangle(50, 50, 30, 30),
                    new Rectangle(60, 60, 20, 20)),
            Arrays.asList(new Rectangle(100, 100, 30, 40),
                    new Rectangle(110, 10, 20, 20),
                    new Rectangle(120, 10, 50, 60))
    );

    // Enfoque iterativo
    List<Rectangle> flatList = new ArrayList<>();
    for (List<Rectangle> rectangleList : rectangleLists) {
      flatList.addAll(rectangleList);  // se mezcla todo en una sola lista
    }

    for (Rectangle rectangle : flatList) {
      System.out.println(rectangle); // Se recorre la lista unificada y se imprime
    }

    Stream<List<Rectangle>> rectangleListStream =
            rectangleLists.stream();
    Stream<Rectangle> rectangleStream = rectangleListStream
            .flatMap((list) -> list.stream());
    rectangleStream.forEach(System.out::println);

    // Se puede reescribir
    rectangleLists.stream()
            .flatMap((list) -> list.stream())
            .forEach(System.out::println);

    System.out.println("usando flatmap");

    //Se cambia la altura de cada rectangulo a 30  y se toman los de área nferior a 900
    rectangleLists.stream()
            .flatMap((list) -> list.stream()
                               .map(r->{r.setHeight(30); return r;})
                               .filter(r -> r.getArea() > 900))
            .map(r -> r.getArea())
            .distinct()
            .forEach(System.out::println);

    //Lazy Evaluation example
    System.out.println("Lazy evaluation example");
    IntUnaryOperator sampleMap = x -> {
      System.out.println("number " + x);
      return x;
    };

    Random random1 = new Random();
    IntStream randomStream = random1.ints().limit(5).map(sampleMap).sorted();
    System.out.println(randomStream);
    randomStream.forEach(System.out::println);

    Function<Integer,Integer> divide = n->1/0;
    Function<Integer,Integer> add = n->n+3;
    Function<Integer,Integer> multiply = n->n*5;
    Function<Integer,Integer> subtract = n->n-4;

    Function[] arr = {divide,add,multiply,subtract};
    Stream<Function> stream1 = Arrays.stream(arr);

    stream1.skip(1).forEach(operation -> System.out.println(operation.apply(2)));

    System.out.println("Understanding inferencia no");
    //This will generate a ConcurrentModificationException exception, since we are trying to modify an ArrayList instance, which is not thread safe.
    /*List<Integer> hours = new ArrayList(
            Arrays.asList(32, 40, 54, 23, 35, 48, 40, 40, 23,
                    54, 45, 44, 45, 65, 34, 35, 42, 42, 50, 45,
                    35, 45, 35, 31, 12, 56));
    Stream<Integer> hoursStream;
    hoursStream = hours.parallelStream();
    int totalHours = hoursStream
            .map(h -> {
              int amount =h*30;
              if(amount>40) {
                hours.add(h+10);
              }
              return amount;
            })
            .reduce(0, (r, s) -> r + s);
    System.out.println(totalHours);*/

    //To avoid this problem using CopyOnWriteArrayList
    CopyOnWriteArrayList<Integer> concurrentHours =
            new CopyOnWriteArrayList(
                    Arrays.asList(32, 40, 54, 23, 35, 48, 40, 40, 23,
                            54, 45, 44, 45, 65, 34, 35, 42, 42, 50, 45,
                            35, 45, 35, 31, 12, 56));
    Stream<Integer> hoursStream;
    hoursStream = concurrentHours.parallelStream();
    int totalHours = hoursStream
            .map(h -> {
              int amount =h*30;
              if(amount>40) {
                concurrentHours.add(h+10);
              }
              return amount;
            })
            .reduce(0, (r, s) -> r + s);
    System.out.println(totalHours);

    System.out.println("Understanding stateless operations");

  }
}

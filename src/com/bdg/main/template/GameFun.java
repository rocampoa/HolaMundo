package com.bdg.main.template;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by Rafael on 1/07/2017.
 * Ejemplo con programación Funcional
 */
public class GameFun {

  Consumer<String> initialize;
  Supplier<String> render;
  Function<String, Integer> update;

  //Template method
  public final void run(String name) {
    initialize.accept(name);
    while (true) {
      String image = render.get();
      System.out.println("Rendering " + image);
      int status = update.apply(name);
      // Evaluate termination conditions
      System.out.println("...");
      break;
    }
  }
}

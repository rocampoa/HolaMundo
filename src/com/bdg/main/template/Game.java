package com.bdg.main.template;

/**
 * Created by Rafael on 1/07/2017.
 * Ejemplo con programación tradicional
 */
public abstract class Game {

  abstract void initailize(String name);
  abstract String render();
  abstract int update(String name);

  public final void run(String name) {
    initailize(name);
    while (true) {
      String image = render();
      System.out.println("Rendering " + image);
      int status = update(name);
      System.out.println("....");
      break;
    }
  }
}

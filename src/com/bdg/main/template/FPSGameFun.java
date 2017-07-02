package com.bdg.main.template;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.Consumer;

/**
 * Created by Rafael on 1/07/2017.
 */
public class FPSGameFun extends GameFun {

  public FPSGameFun(Consumer<String> initialize,
                    Supplier<String> render,
                    Function<String, Integer> update) {
    this.initialize = initialize;
    this.render = render;
    this.update = update;
    run("FPS Game");
  }
}

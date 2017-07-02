package com.bdg.main.template;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by Rafael on 1/07/2017.
 */
public class StrategyGameFun extends GameFun {

  public StrategyGameFun(Consumer<String> initialize,
                         Supplier<String> render,
                         Function<String, Integer> update) {
    this.initialize = initialize;
    this.render = render;
    this.update = update;
    run("Strategy Game");
  }
}

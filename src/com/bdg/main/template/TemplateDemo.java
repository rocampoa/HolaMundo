package com.bdg.main.template;

/**
 * Created by Rafael on 1/07/2017.
 */
public class TemplateDemo {

  public static void main(String[] args) {
    FPSGame fpsGame = new FPSGame();
    StrategyGame strategyGame = new StrategyGame();
    // Opcion funcional
    StrategyGameFun strategyGameFun = new StrategyGameFun(n -> System.out.println("Starting  fff " + n),
            () -> {
              System.out.println("Generating Strategy Image");
              return "Strategy Image";
            },
            t -> {
              System.out.println(t);
              return 0;
            }
    );
  }
}

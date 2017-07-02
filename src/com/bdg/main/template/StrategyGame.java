package com.bdg.main.template;

/**
 * Created by Rafael on 1/07/2017.
 */
public class StrategyGame extends Game {

  public StrategyGame() {
    run("Strategy Game");
  }

  @Override
  void initailize(String name) {
    System.out.println("Starting " + name);
  }

  @Override
  String render() {
    System.out.println("Generating Strategy Image");
    return "Strategy Image";
  }

  @Override
  int update(String name) {
    System.out.println("Updating " + name);
    return 0;
  }
}

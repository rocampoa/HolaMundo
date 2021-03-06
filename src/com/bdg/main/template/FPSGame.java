package com.bdg.main.template;

/**
 * Created by Rafael on 1/07/2017.
 */
public class FPSGame extends Game {

  public FPSGame() {
    run("FPS Game");
  }

  @Override
  void initailize(String name) {
    System.out.println("Starting: " + name);
  }

  @Override
  String render() {
    System.out.println("Generating FPS Image");
    return "FPS Image";
  }

  @Override
  int update(String name) {
    System.out.println("Updating " + name);
    return 0;
  }
}

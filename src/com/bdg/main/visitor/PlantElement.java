package com.bdg.main.visitor;

/**
 * Created by Rafael on 1/07/2017.
 */
public class PlantElement implements ISceneElement {

  private String name;

  public PlantElement(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

}

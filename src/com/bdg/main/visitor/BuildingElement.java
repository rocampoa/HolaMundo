package com.bdg.main.visitor;

/**
 * Created by Rafael on 1/07/2017.
 */
public class BuildingElement implements ISceneElement {

  private String name;

  public BuildingElement(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return this.name;
  }

}

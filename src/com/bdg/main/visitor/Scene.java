package com.bdg.main.visitor;

/**
 * Created by Rafael on 1/07/2017.
 */
public class Scene implements ISceneElement {

  private ISceneElement[] elements;
  private String name;

  public Scene(String name) {
    this.name = name;
    this.elements = new ISceneElement[] {
            new BuildingElement("Tool Shed"),
            new BuildingElement("Brick House"),
            new PlantElement("Oak Tree") ,
            new PlantElement("Lawn") };
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public void accept(ISceneElementVisitor visitor) {
    for (ISceneElement elem : elements) {
      elem.accept(visitor);
    }
    visitor.visit(this);
  }

}

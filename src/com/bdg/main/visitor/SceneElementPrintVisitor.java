package com.bdg.main.visitor;

/**
 * Created by Rafael on 1/07/2017.
 */
public class SceneElementPrintVisitor implements ISceneElementVisitor {

  @Override
  public void visit(ISceneElement element) {
    System.out.println("Printing: " + element.getName());
  }
}

package com.bdg.main.visitor;

/**
 * Created by Rafael on 1/07/2017.
 */
public class SceneElementRefreshVisitor implements ISceneElementVisitor {

  @Override
  public void visit(ISceneElement element) {
    System.out.println("Refreshing " + element.getName());
  }
}

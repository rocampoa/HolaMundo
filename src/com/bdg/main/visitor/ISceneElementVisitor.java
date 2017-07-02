package com.bdg.main.visitor;

/**
 * Created by Rafael on 1/07/2017.
 * Parte del ejemplo patrón Visitor
 */
@FunctionalInterface
public interface ISceneElementVisitor {

  /**
   * Toma un elemento y lo visita
   * @param element
   */
  void visit(ISceneElement element);
}

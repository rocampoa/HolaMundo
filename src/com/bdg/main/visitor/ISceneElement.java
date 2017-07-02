package com.bdg.main.visitor;

/**
 * Created by Rafael on 1/07/2017.
 * Parte del ejemplo del patrón Visitor
 */
@FunctionalInterface
public interface ISceneElement {
  String getName();

  /**
   * M&eacute;todo que inicia la aplicaci&oacute;n de operaci&oacute;n de visita contra el elemento.
   * @param visitor
   */
  default void accept(ISceneElementVisitor visitor) {
     visitor.visit(this);
  }
}

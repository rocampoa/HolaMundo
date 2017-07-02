package com.bdg.main.visitor;

/**
 * Created by Rafael on 1/07/2017.
 * Wjemplo del patrón Visitor
 */
public class SceneVisitorDemo {

  public static void main(String[] args) {
    System.out.println("Ejemplo con la forma tradicional");
    ISceneElement scene = new Scene("Primary Scene");
    scene.accept(new SceneElementPrintVisitor());
    scene.accept(new SceneElementRefreshVisitor());
    scene.accept(t -> System.out.println("Otra operacion visitante: " + t.getName()));
  }
}

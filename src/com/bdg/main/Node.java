package com.bdg.main;

/**
 * Created by Rafael on 23/06/2017.
 */
public class Node {

  private int value;
  private Node left;
  private Node right;


  public Node(int value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }


  public Node(Node node) {
    this.value = node.value;
    this.left = null;
    this.right = null;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public Node getLeft() {
    return left;
  }

  public void setLeft(Node left) {
    this.left = left;
  }

  public Node left() {
    return this.left;
  }

  public Node addLeft(Node node) {
    this.left = node;
    return node;
  }

  public Node addLeft(int value) {
    this.left = new Node(value);
    return this.left;
  }

   public Node right() {
    return this.right;
  }

  public Node addRight(Node node) {
    this.right = node;
    return node;
  }

  public Node addRight(int value) {
    this.right = new Node(value);
    return this.right;
  }



  public Node getRight() {
    return right;
  }

  public void setRight(Node right) {
    this.right = right;
  }

  public static void inOrder(Node root) {
    if (root != null) {
      inOrder(root.left);
      System.out.println(root.getValue() + " - ");
      inOrder(root.right);
    }
  }

  public static void preOrder(Node root) {
    if (root != null) {
      System.out.println(root.getValue() + " - ");
      preOrder(root.left);
      preOrder(root.right);
    }
  }

  public static void postOrder(Node root) {
    if (root != null) {
      postOrder(root.left);
      postOrder(root.right);
      System.out.println(root.getValue() + " - ");
    }
  }


}

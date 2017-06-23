package com.bdg.main;

/**
 * Created by Rafael on 21/06/2017.
 * Clase ejemplo para el uso de stream
 */
public class Rectangle {

  private int x;
  private int y;
  private int height;
  private int width;

  public Rectangle(int x, int y, int height, int width) {
    this.x = x;
    this.y = y;
    this.height = height;
    this.width = width;
  }

  public Rectangle scale(double percent) {
    height = (int) (height * (1.0 + percent));
    width = (int) (width * (1.0 + percent));
    return this;
  }

  public int getArea() {
    return height * width;
  }

  @Override
  public String toString() {
    return "X: " + x + " Y: " + y + " Height: " + height + " Width: " + width;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }
}

package com.bdg.main;

/**
 * @author Rafael on 20/06/2017.
 * Ejemplo de extensión de una clase con interfaz Fluent.
 */
public class SailBoat extends BaseBoat<SailBoat> {

  private int numberOfSails;
  private int numberOfHulls;

  public int getNumberOfSails() {
    return numberOfSails;
  }

  public void setNumberOfSails(int numberOfSails) {
    this.numberOfSails = numberOfSails;
  }

  public SailBoat sails(int numberOfSails) {
    this.numberOfSails = numberOfSails;
    return this;
  }

  public int getNumberOfHulls() {
    return numberOfHulls;
  }

  public void setNumberOfHulls(int numberOfHulls) {
    this.numberOfHulls = numberOfHulls;
  }

  public SailBoat hulls(int numberOfHulls) {
    this.numberOfHulls = numberOfHulls;
    return this;
  }

  @Override
  public String toString() {
    return super.toString() + " Number of Sails: " + this.numberOfSails + " Number of Hulls: " + this.numberOfHulls;
  }
}

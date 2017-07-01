package com.bdg.main;

import java.util.Optional;

/**
 * Created by Rafael on 30/06/2017.
 */
public class Part {

  private int partNumber;
  private String partName;
  private boolean outOfStock;

  public Part(int partNumber, String partName) {
    this.partNumber = partNumber;
    this.partName = partName;
  }

  public int getPartNumber() {
    return partNumber;
  }

  public void setPartNumber(int partNumber) {
    this.partNumber = partNumber;
  }

  public String getPartName() {
    return partName;
  }

  public void setPartName(String partName) {
    this.partName = partName;
  }

  public Optional<Part> partName(String partName) {
    this.partName = partName;
    return Optional.of(this);
  }

  public boolean isOutOfStock() {
    return outOfStock;
  }

  public void setOutOfStock(boolean outOfStock) {
    this.outOfStock = outOfStock;
  }

  public Optional<Part> outOfStock(boolean outOfStock) {
    this.outOfStock = outOfStock;
    return Optional.of(this);
  }

  public Optional<Part> replicatePartMonad() {
    System.out.println("Part Replicate: " + this);
    return Optional.of(this);
  }

  @Override
  public String toString() {
    return "Part{partNumber=" + partNumber + ", partName=" + partName + ", outOfStock=" + outOfStock + "}";
  }
}

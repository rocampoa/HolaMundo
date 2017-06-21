package com.bdg.main;

import java.util.Random;

/**
 * @author  Rafael on 20/06/2017.
 * Reemplazando la interfaz de la clase Random por una fluent
 */
public class FluentRandom extends Random {

  private int lower = 0;
  private int upper = Integer.MAX_VALUE;

  @Override
  public int nextInt() {
    return lower + this.nextInt(upper - lower);
  }

  public FluentRandom useAsSeed(long seed) {
    this.setSeed(seed);
    return this;
  }

  public FluentRandom asLower(int lower) {
    this.lower = lower;
    return this;
  }

  public FluentRandom asUpper(int upper) {
    this.upper = upper;
    return this;
  }

  public int getLower() {
    return lower;
  }

  public void setLower(int lower) {
    this.lower = lower;
  }

  public int getUpper() {
    return upper;
  }

  public void setUpper(int upper) {
    this.upper = upper;
  }
}

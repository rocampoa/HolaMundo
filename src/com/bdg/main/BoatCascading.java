package com.bdg.main;

/**
 * Created by Rafael on 20/06/2017.
 */
public class BoatCascading {

  private String name;
  private String country;
  private int tonnage;
  private int draft;

  public String getName() {
    return name;
  }

  public BoatCascading setName(String name) {
    this.name = name;
    return this;
  }

  public String getCountry() {
    return country;
  }

  public BoatCascading setCountry(String country) {
    this.country = country;
    return this;
  }

  public int getTonnage() {
    return tonnage;
  }

  public BoatCascading setTonnage(int tonnage) {
    this.tonnage = tonnage;
    return this;
  }

  public int getDraft() {
    return draft;
  }

  public BoatCascading setDraft(int draft) {
    this.draft = draft;
    return this;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Name :").append(this.name).append(" Country: ").append(this.country)
            .append(" Tonnage: ").append(this.tonnage).append(" Draft: ").append(this.draft);
    return sb.toString();
  }
}

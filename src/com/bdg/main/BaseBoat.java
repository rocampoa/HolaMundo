package com.bdg.main;

/**
 * Created by Rafael on 20/06/2017.
 */
public class BaseBoat<T extends BaseBoat<T>> {

  private String name;
  private String country;
  private int tonnage;
  private int draft;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public T named(String name) {
    this.name = name;
    return (T) this;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public T country(String country) {
    this.country = country;
    return (T) this;
  }

  public int getTonnage() {
    return tonnage;
  }

  public void setTonnage(int tonnage) {
    this.tonnage = tonnage;
  }

  public T tonnage(int tonnage) {
    this.tonnage = tonnage;
    return (T) this;
  }

  public int getDraft() {
    return draft;
  }

  public void setDraft(int draft) {
    this.draft = draft;
  }
  public T draft(int draft) {
    this.draft = draft;
    return (T) this;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Name :").append(this.name).append(" Country: ").append(this.country)
            .append(" Tonnage: ").append(this.tonnage).append(" Draft: ").append(this.draft);
    return sb.toString();
  }
}

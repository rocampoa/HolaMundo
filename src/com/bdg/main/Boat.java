package com.bdg.main;

/**
 * Created by Rafael on 18/06/2017.
 */
public class Boat {

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

  public Boat named(String name) {
    this.name = name;
    return this;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Boat country(String country) {
    this.country = country;
    return this;
  }

  public int getTonnage() {
    return tonnage;
  }

  public void setTonnage(int tonnage) {
    this.tonnage = tonnage;
  }

  public Boat tonnage(int tonnage) {
    this.tonnage = tonnage;
    return this;
  }

  public int getDraft() {
    return draft;
  }

  public void setDraft(int draft) {
    this.draft = draft;
  }

  public Boat draft(int draft) {
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

  public static void main(String[] args) {
    // Método tradicional
    Boat boat = new Boat();
    boat.setCountry("Panama");
    boat.setName("Albatross");
    boat.setTonnage(12000);
    boat.setDraft(25);
    System.out.println(boat);

    //Técnica de Cascading a mi se me hace Como un Builder Pattern
    BoatCascading bc = new BoatCascading();
    bc.setName("Albatros").setCountry("Panama").setTonnage(12000).setDraft(25);
    System.out.println(bc);

    //Aplicando Fluent Interfaces, essencially setter methods violate the standard Java naming conventions
    boat = new Boat();
    boat.country("Colombia").tonnage(12500).draft(35).named("Rocampo");
    System.out.println(boat);

    //Usando Fluent intefaces to hide older interfaces/classes
    FluentRandom fr = new FluentRandom();
    for (int i = 0; i < 5; i++) {
      System.out.println(fr.nextInt());
    }

    fr = new FluentRandom().asLower(5).asUpper(25).useAsSeed(35);
    for (int i = 0; i < 5; i++) {
      System.out.println(fr.nextInt());
    }

    /*
    Extending Fluent interfaces: Fluent interfaces are elegant and can be extended if needed . However, you have to be
    careful when you do this. The Key to the approach is to use generics.
    */
    SailBoat sailBoat = new SailBoat().named("Endeavor").country("United Kingdom").sails(3).tonnage(15).hulls(2);
    System.out.println(sailBoat);

  }
}

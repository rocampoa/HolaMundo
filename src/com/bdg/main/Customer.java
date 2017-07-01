package com.bdg.main;

/**
 * Created by Rafael on 18/06/2017.
 */
public class Customer {
  private String emailAddress;
  private int id;
  private String name;

  public Customer(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public Customer(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Customer { id=" + id + ", name=" + name + "}";
  }
}

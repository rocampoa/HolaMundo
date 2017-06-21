package com.bdg.main;

/**
 * Created by Rafael on 18/06/2017.
 */
public class Customer {
  private String emailAddress;

  public Customer(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }
}

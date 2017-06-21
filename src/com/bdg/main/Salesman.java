package com.bdg.main;

import java.util.function.Function;

/**
 * Created by Rafael on 18/06/2017.
 */
public class Salesman {

  private Customer bestCustomer;

  public Salesman(Customer bestCustomer) {
    this.bestCustomer = bestCustomer;
  }

  public Customer getBestCustomer() {
    return bestCustomer;
  }

  public void setBestCustomer(Customer bestCustomer) {
    this.bestCustomer = bestCustomer;
  }

  public static void main(String[] args) {
    Customer customer = new Customer("xx@xx.com");
    Salesman salesman = new Salesman(customer);
    System.out.println(salesman.getBestCustomer().getEmailAddress());

    // Lo mismo pero con programación funcional
    Function<Customer, String> customerToEmail = Customer::getEmailAddress;
    Function<Salesman, Customer> salesmanToBestCustomer = Salesman::getBestCustomer;
    Function<Salesman, String> toEmailAddress = salesmanToBestCustomer.andThen(customerToEmail);
    System.out.println(toEmailAddress.apply(salesman));
  }
}

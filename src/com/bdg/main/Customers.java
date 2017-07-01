package com.bdg.main;

import java.util.HashMap;
import java.util.Optional;

/**
 * Created by Rafael on 28/06/2017.
 */
public class Customers {

  private HashMap<Integer, Customer> customers;

  public Customers() {
    customers = new HashMap<>();
  }

  public void addCustomer(int id, Customer customer) {
    customers.put(id, customer);
  }

  public Customer findCustomerWithID(int id) {
    if(customers.containsKey(id)) {
      return customers.get(id);
    } else {
      return null;
    }
  }

  public Optional<Customer> findOptionalCustomerWithID(int id) {
      return Optional.ofNullable(customers.get(id));
  }


}

package com.hz.services;

import com.hz.daomain.Customer;

import java.util.List;

public interface CustomerServices {

    List<Customer> findAllCustomer();

    int addCustomer(Customer customer);
}

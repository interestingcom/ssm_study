package com.hz.dao;

import com.hz.daomain.Customer;

import java.util.List;

public interface CustomerDao {
    List<Customer> findAllCostumer();
    int  addCustomer (Customer customer);
}

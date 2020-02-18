package com.hz.services;

import com.hz.dao.CustomerDao;
import com.hz.daomain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerServicesImpl implements CustomerServices {

    @Autowired
    private CustomerDao customerDao;
    @Override
    public List<Customer> findAllCustomer() {

       return customerDao.findAllCostumer();

    }

    @Override
    public int addCustomer(Customer customer) {
        return customerDao.addCustomer(customer);
    }
}

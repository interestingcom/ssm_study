package com.hz.dao;

import com.hz.daomain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class CustomerDaoImpl extends JdbcDaoSupport implements CustomerDao {


    @Autowired
    public void init(DataSource dataSource){
        super.setDataSource(dataSource);
    }


    public List<Customer> findAllCostumer() {
        String sql="select cust_name,cust_level,cust_source,cust_linkman,cust_phone,cust_mobile from cst_customer";
        BeanPropertyRowMapper<Customer> mapper = new BeanPropertyRowMapper<>(Customer.class);
        List<Customer> costumers = getJdbcTemplate().query(sql,mapper);
        return costumers;
    }

    public int  addCustomer (Customer customer) {
        String sql="insert  into cst_customer(cust_name,cust_linkman,cust_mobile,cust_level,cust_source,cust_phone) values (?,?,?,?,?,?)";

        return getJdbcTemplate().update(sql,customer.getCust_name(),customer.getCust_linkman(),customer.getCust_mobile(),customer.getCust_level(),customer.getCust_source(),customer.getCust_phone());
    }
}

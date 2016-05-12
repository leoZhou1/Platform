package com.website.demo.service;

import java.util.List;
import java.util.Map;

import com.website.demo.model.Customer;
public interface CustomerService {

	List<Customer> getCustomerList();

	Customer getCustomer(long id);

	boolean createCustomer(Map<String, Object> fieldMap);

	boolean updateCustomer(long id, Map<String, Object> fieldMap);

	boolean deleteCustomer(long id);

}
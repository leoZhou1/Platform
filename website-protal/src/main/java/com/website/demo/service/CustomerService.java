package com.website.demo.service;

import java.util.List;
import java.util.Map;

import com.website.demo.helper.DatabaseHelper;
import com.website.demo.model.Customer;

public class CustomerService {
		
	
	public List<Customer> getCustomerList(){
		String sql = "SELECT * FROM CUSTOMER";
		List<Customer> list = DatabaseHelper.queryList(Customer.class, sql, null);
		return list;
	}
	
	public Customer getCustomer(long id){
		
		return null;
	}
	
	public boolean createCustomer(Map<String, Object> fieldMap){
		
		return false;
	}
	
	public boolean updateCustomer(long id,Map<String,Object> fieldMap){
		
		return false;
	}
	public boolean deleteCustomer(long id){
		
		return false;
	}
}

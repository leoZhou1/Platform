package com.website.protal.test;

import java.util.List;

import org.junit.Before;

import com.website.demo.model.Customer;
import com.website.demo.service.CustomerService;

import junit.framework.Assert;

public class CustomerTest {
	private final CustomerService customerService;
	
	public CustomerTest(){
		customerService = new CustomerService();
	}
	
	@Before
	public void init(){
		//初始化数据库
		
	}
	
	public void getCustomerListTest(){
		List<Customer> list = customerService.getCustomerList();
		Assert.assertEquals(2, list.size());
	}
	
}

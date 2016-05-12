package com.website.protal.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.website.demo.model.Customer;
import com.website.demo.service.CustomerService;
import com.website.demo.service.impl.CustomerServiceImpl;

import junit.framework.Assert;

public class CustomerTest {
	private final CustomerService customerService;
	
	public CustomerTest(){
		customerService = new CustomerServiceImpl();
	}
	
	@Before
	public void init(){
		//初始化数据库
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void getCustomerListTest(){
		List<Customer> list = customerService.getCustomerList();
		System.out.println(list.size());
		Assert.assertEquals(2, list.size());
	}
	
}

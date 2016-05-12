package com.website.demo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.website.demo.helper.DatabaseHelper;
import com.website.demo.model.Customer;
import com.website.demo.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService {
		
	
	/* (non-Javadoc)
	 * @see com.website.demo.service.CustomerService#getCustomerList()
	 */
	@Override
	public List<Customer> getCustomerList(){
		String sql = "SELECT * FROM CUSTOMER";
		List<Customer> list = DatabaseHelper.queryList(Customer.class, sql, null);
		return list;
	}
	
	/* (non-Javadoc)
	 * @see com.website.demo.service.CustomerService#getCustomer(long)
	 */
	@Override
	public Customer getCustomer(long id){
		
		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.website.demo.service.CustomerService#createCustomer(java.util.Map)
	 */
	@Override
	public boolean createCustomer(Map<String, Object> fieldMap){
		
		return false;
	}
	
	/* (non-Javadoc)
	 * @see com.website.demo.service.CustomerService#updateCustomer(long, java.util.Map)
	 */
	@Override
	public boolean updateCustomer(long id,Map<String,Object> fieldMap){
		
		return false;
	}
	/* (non-Javadoc)
	 * @see com.website.demo.service.CustomerService#deleteCustomer(long)
	 */
	@Override
	public boolean deleteCustomer(long id){
		
		return false;
	}
}

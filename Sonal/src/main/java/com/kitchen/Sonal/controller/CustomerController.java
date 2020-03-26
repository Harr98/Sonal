package com.kitchen.Sonal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kitchen.Sonal.model.Customer;
import com.kitchen.Sonal.model.Menu;
import com.kitchen.Sonal.repository.CustomerRepository;
import com.kitchen.Sonal.repository.MenuRepository;

@RestController
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private MenuRepository menuRepository;
	@GetMapping("/customer")
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}
	@GetMapping("/customer/{pid}")
	public List<Customer> getCustomer(@PathVariable("pid") long pid) {
		return customerRepository.findByMenuId(pid);
	}
	@PostMapping("/customer")
	public Customer postCustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}
	
	@PutMapping("/customer/{cid}")
	public Customer updateCustomer(@PathVariable("cid") long cid,@RequestBody Customer customer) {
		Customer c=customerRepository.getOne(cid);
		c.setAddress(customer.getAddress());;
		c.setName(customer.getName());
		return customerRepository.save(c);
	}
	@DeleteMapping("/customer/{cid}")
	public void deleteCustomer(@PathVariable("cid") long cid) {
		customerRepository.deleteById(cid);
		
	}
	@PostMapping("/buysproduct/{cid}/{pid}")
	public void buysProduct(@PathVariable("cid") long cid,@PathVariable("pid") long pid) {
		Customer c=customerRepository.getOne(cid);
		Menu m=menuRepository.getOne(pid);
		List<Menu> list=c.getMenu();
		list.add(m);
		c.setMenu(list);
		customerRepository.save(c);
	}
	
	@PostMapping("/buysproductNative/{cid}/{pid}")
	public void buysProductNative(@PathVariable("cid") long cid,@PathVariable("pid") long pid) {
		customerRepository.buysProduct(cid, pid);
	}

	
}

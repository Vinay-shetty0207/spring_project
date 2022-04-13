package com.tns.order;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderdetailsController 
{
	@Autowired
	private OrderDetailsServices service;
	
	@GetMapping("/orderdetails")
	public List<OrderDetails> list()
	{
		return service.listAll();
	}
	
	
	@GetMapping("/orderdetails/{id}")
	 public ResponseEntity<OrderDetails> get(@PathVariable Integer id) 
	 {
	 try
	 {
	  OrderDetails OrderDetails = service.get(id);
	 return new ResponseEntity<OrderDetails>(OrderDetails, HttpStatus.OK);
	 } 
	 catch (NoSuchElementException e) 
	 {
	 return new ResponseEntity<OrderDetails>(HttpStatus.NOT_FOUND);
	 } 
	 }
	
	@PostMapping("/orderdetails")
	public void add(@RequestBody OrderDetails OrderDetails)
	{
		service.save(OrderDetails);
	}

	@PutMapping("/orderdetails/{id}")
	public ResponseEntity<?> update(@RequestBody  OrderDetails OrderDetails, @PathVariable Integer id) 
	{
		try {
			OrderDetails existOrderDetails = service.get(id);
				service.save(OrderDetails);
				return new ResponseEntity<>(HttpStatus.OK);
			}
		catch (NoSuchElementException e)
		{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/orderdetails/{id}")
	public void delete(@PathVariable Integer id) 
	{
		service.delete(id);
	}
}

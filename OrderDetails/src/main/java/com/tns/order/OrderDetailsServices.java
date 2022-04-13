package com.tns.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderDetailsServices {

	@Autowired
	private OrderDetailsRepository repository;

	public OrderDetails get(Integer id) {
		return repository.findById(id).get();
	}

	public void delete(Integer id) {
		repository.deleteById(id);

	}

	public void save(OrderDetails OrderDetails) {
		repository.save(OrderDetails);

	}

	public List<OrderDetails> listAll() {
		return repository.findAll();
	}

}
package com.mock.project.service;

import java.util.List;

import com.sapient.mockProject.pojo.Order;

public interface OrderService {
	
	List<Order> display();
	
	void updateStatus(long block_id,List order_id);

}
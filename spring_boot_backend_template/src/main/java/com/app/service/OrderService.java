package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Orderr;
import com.app.repository.OrderRepo;

@Service
public class OrderService implements OrderServiceImpl
{
   @Autowired
	
   private OrderRepo orderRepository;

   public List<Orderr> getAllOrders() {
       return orderRepository.findAll();
   }

   public Optional<Orderr> getOrderById(Long id) {
       return orderRepository.findById(id);
   }

   public Orderr saveOrder(Orderr order) {
       return orderRepository.save(order);
   }

   public void deleteOrder(Long id) {
       orderRepository.deleteById(id);
		
	}

}

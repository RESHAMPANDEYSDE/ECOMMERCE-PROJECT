package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.model.Orderr;

public interface OrderServiceImpl
{
	List<Orderr> getAllOrders();

    Optional<Orderr> getOrderById(Long id);

    Orderr saveOrder(Orderr order);

    void deleteOrder(Long id);
}

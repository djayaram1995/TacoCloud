package com.shop.taco.repository;

import com.shop.taco.model.Order;

public interface OrderRepository {
 Order save(Order order);
}
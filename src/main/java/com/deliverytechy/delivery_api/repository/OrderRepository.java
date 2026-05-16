package com.deliverytechy.delivery_api.repository;

import com.deliverytechy.delivery_api.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}

package com.restaurant.demo.repository;

import com.restaurant.demo.dto.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {


}

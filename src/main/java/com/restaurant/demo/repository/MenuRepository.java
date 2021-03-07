package com.restaurant.demo.repository;

import com.restaurant.demo.dto.Menus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends CrudRepository<Menus, Integer> {


}

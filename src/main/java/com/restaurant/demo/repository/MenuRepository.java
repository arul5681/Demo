package com.restaurant.demo.repository;

import com.restaurant.demo.dto.Menus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends CrudRepository<Menus, Integer> {


}

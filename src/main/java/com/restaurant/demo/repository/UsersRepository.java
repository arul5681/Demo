package com.restaurant.demo.repository;

import com.restaurant.demo.dto.Menus;
import com.restaurant.demo.dto.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<User, Integer> {


}

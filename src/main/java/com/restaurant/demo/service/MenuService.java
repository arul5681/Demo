package com.restaurant.demo.service;

import com.restaurant.demo.dto.Menus;
import com.restaurant.demo.dto.Order;
import com.restaurant.demo.dto.User;
import com.restaurant.demo.dto.UserOrder;
import com.restaurant.demo.repository.OrderRepository;
import com.restaurant.demo.repository.UsersRepository;
import com.restaurant.demo.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.restaurant.demo.repository.MenuRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private OrderRepository orderRepository;

    public void setupTestData(){

        List<Menus> itemsList = new ArrayList<Menus>();
        List<User> usersList = new ArrayList<>();
        try {
            if(!menuRepository.existsById(new Integer(1))) {
                itemsList.add(Menus.builder().menu_id(101).category("Soup").itemName("Chicken Soup").itemNo(new Integer(105)).price(new Integer(5)).quantityAvailable("50").build());
                itemsList.add(Menus.builder().menu_id(101).category("Starter").itemName("Chicken Lolipop").itemNo(new Integer(106)).price(new Integer(7)).quantityAvailable("50").build());
                itemsList.add(Menus.builder().menu_id(101).category("Main").itemName("Chicken Biryani").itemNo(new Integer(107)).price(new Integer(13)).quantityAvailable("50").build());
                menuRepository.saveAll(itemsList);

                usersList.add(User.builder().id(1).name("Arumugam Ponnaiah").userid("arul5681").password("test").signedin(false).build());
                usersList.add(User.builder().id(2).name("Anbuselvi Arumugam").userid("anbu0520").password("test").signedin(false).build());
                usersList.add(User.builder().id(3).name("Lakshana Arumugam ").userid("laks0610").password("test").signedin(false).build());
                usersRepository.saveAll(usersList);
            }

        }catch (Exception e) {
            log.error("Error occurred in retrieving menu items");
            e.printStackTrace();
        }
    }

    public List<Menus> getMenuItems(){
        List<Menus> menuList = new ArrayList<Menus>();
        try {
            menuRepository.findAll().forEach(item -> menuList.add(item));
        }catch (Exception e) {
            log.error("Error occurred in retrieving menu items");
            e.printStackTrace();
        }
        return  menuList;
    }

    public String saveOrder(UserOrder order){
        try {
            List<String> userMenus = order.getMenuId();
            List<Order> orderToSave = new ArrayList<>();

            if (userMenus.size() > 0) {
                userMenus.stream().forEach(
                        menuId -> {
                            orderToSave.add(Order.builder().id(order.getOrder_id()).menuId(menuId).userId(order.getUserId()).build());
                        });

                orderRepository.saveAll(orderToSave);
            }
        }catch (Exception e) {
            log.error("Error occurred in Saving Order from User");
            e.printStackTrace();
            return Constants.SYSTEM_ERROR;
        }

        log.info("Order Saved--Success");
        return Constants.SUCCESS;
    }
}

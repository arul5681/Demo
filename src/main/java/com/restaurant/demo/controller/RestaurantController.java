package com.restaurant.demo.controller;

import com.restaurant.demo.dto.Menus;
import com.restaurant.demo.dto.OrderResponse;
import com.restaurant.demo.dto.UserOrder;
import com.restaurant.demo.service.MenuService;
import com.restaurant.demo.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value="/desiRestaurant")
public class RestaurantController {

    @Autowired
    MenuService menuService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/getMenu", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Menus> getMenuItems(){
        menuService.setupTestData();
        List<Menus> menuList = menuService.getMenuItems();
        log.info("MenuItems size:"+menuList.size());
        return menuList;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/receiveOrder",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public OrderResponse receiveOrder(@RequestBody UserOrder userOrder){
        menuService.setupTestData();
        //UserOrder userOrder = (UserOrder) CommonUtil.transformJSONToPojo(userOrderString);
        OrderResponse response1 = new OrderResponse();

        if(StringUtils.isEmpty(userOrder.getUserId())){
            response1.setConfirmation(Constants.USERID_MISSING);
            response1.setErrorMessage(Constants.USERID_MISSING);
            return response1;
        }
        else if(userOrder.getMenuId().size()==0){
            response1.setConfirmation(Constants.EMPTY_MENU);
            response1.setErrorMessage(Constants.EMPTY_MENU);
            return response1;
        }

        String response = menuService.saveOrder(userOrder);
        log.info("Receive Order--response:"+response);
        if(Constants.SUCCESS.equalsIgnoreCase(response)){
            response1.setConfirmation(Constants.ORDER_CONFIRM);
            response1.setErrorMessage(Constants.NONE);
        }
        else{
            response1.setConfirmation(Constants.SYSTEM_ERROR);
            response1.setErrorMessage(Constants.SYSTEM_ERROR);
        }
            return response1;
    }

}

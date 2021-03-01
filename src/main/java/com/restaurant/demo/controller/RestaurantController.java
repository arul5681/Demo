package com.restaurant.demo.controller;

import com.restaurant.demo.dto.Menus;
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

    @GetMapping(value = "/getMenu", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Menus> getMenuItems(){
        menuService.setupTestData();
        List<Menus> menuList = menuService.getMenuItems();
        log.info("MenuItems size:"+menuList.size());
        return menuList;
    }

    @PostMapping(path = "/receiveOrder",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public String receiveOrder(@RequestBody UserOrder userOrder){
        menuService.setupTestData();
        //UserOrder userOrder = (UserOrder) CommonUtil.transformJSONToPojo(userOrderString);
        if(StringUtils.isEmpty(userOrder.getUserId()))
            return Constants.USERID_MISSING;
        else if(userOrder.getMenuId().size()==0)
            return  Constants.EMPTY_MENU;
        String response = menuService.saveOrder(userOrder);
        log.info("Receive Order--response:"+response);
        if(Constants.ORDER_CONFIRM.equalsIgnoreCase(response))
           return response;
        else
            return Constants.SYSTEM_ERROR;
    }

}

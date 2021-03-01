package com.restaurant.demo.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserOrder  {
    private long order_id;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getMenuId() {
        return menuId;
    }

    public void setMenuId(List<String> menuId) {
        this.menuId = menuId;
    }

    private String userId;
    private List<String> menuId;

    public UserOrder(){

    }

    public UserOrder(long order_id, String userId, List<String> menuId) {
        super();
        this.order_id = order_id;
        this.userId = userId;
        this.menuId = menuId;
    }

    public UserOrder(UserOrder order) {
        this.order_id = order.getOrderId();
        this.userId = order.getUserId();
        this.menuId = order.getMenuId();
    }

    public long getOrderId() {
        return order_id;
    }

    public void setOrderId(long id) {
        this.order_id = id;
    }

}

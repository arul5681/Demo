package com.restaurant.demo.dto;

import lombok.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserOrder  {
    private long order_id;

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setMenuId(List<String> menuId) {
        this.menuId = menuId;
    }

    public String getUserId() {
        return userId;
    }

    public List<String> getMenuId() {
        return menuId;
    }

    private String userId;
    private List<String> menuId;


}

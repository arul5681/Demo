package com.restaurant.demo.dto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Builder;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

    @Entity
    @Builder
    @Table(name="orders")
    public class Order implements Serializable {

        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        @Column(name="order_id")
        private long id;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        @OneToMany(fetch = FetchType.EAGER)
        public String getMenuId() {
            return menuId;
        }

        public void setMenuId(String menuId) {
            this.menuId = menuId;
        }

        @Column(name="user_id")
        private String userId;

        @Column(name="menu_id")
        private String menuId;

        @Override
        public String toString() {
            return "Order [id=" + id + ", user=" + userId + ", menus=" + menuId + "]";
        }

        public Order(){

        }

        public Order(long id, String userId, String menuId) {
            super();
            this.id = id;
            this.userId = userId;
            this.menuId = menuId;
        }

        public Order(Order order) {
            this.id = order.getId();
            this.userId = order.getUserId();
            this.menuId = order.getMenuId();
        }


        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

    }

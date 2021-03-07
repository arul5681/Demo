package com.restaurant.demo.dto;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;

    @Entity
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Table(name="orders")
    public class Order implements Serializable {

        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        @Column(name="order_id")
        private long id;
        @Column(name="user_id")
        private String userId;

        @Column(name="menu_id")
        private String menuId;
    }

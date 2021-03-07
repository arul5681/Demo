package com.restaurant.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Builder
@AllArgsConstructor
public class Menus implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int menu_id;
    public String category;
    public Integer itemNo;
    public String itemName;
    public String quantityAvailable;
    public int price;

    public Menus() {

    }
}

package com.restaurant.demo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class OrderResponse {
    private String confirmation;
    private String errorMessage;

}

package com.study.modulearchive.controller.dto;

import com.study.modulearchive.domain.Order;

import java.util.List;

public record OrdersResponse(List<Order> orders) {

    public static OrdersResponse of(List<Order> order) {
           return new OrdersResponse(order);
    }

}

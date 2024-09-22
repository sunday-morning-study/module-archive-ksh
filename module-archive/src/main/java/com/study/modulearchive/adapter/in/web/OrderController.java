package com.study.modulearchive.adapter.in.web;

import com.study.modulearchive.domain.Order;
import com.study.modulearchive.repository.OrderSearch;
import com.study.modulearchive.application.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity order(@RequestParam("memberId") Long memberId,
                                @RequestParam("itemId") Long itemId,
                                @RequestParam("count") int count) {

        Long order = orderService.order(memberId, itemId, count);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/orders")
    public ResponseEntity orderList(@RequestBody OrderSearch orderSearch) {
        List<Order> orders = orderService.findOrders(orderSearch);

        return ResponseEntity.ok(orders);
    }

    @PostMapping("/orders/{orderId}/cancel")
    public String cancelOrder(@PathVariable("orderId") Long orderId) {
        orderService.cancelOrder(orderId);
        return "redirect:/orders";
    }

}

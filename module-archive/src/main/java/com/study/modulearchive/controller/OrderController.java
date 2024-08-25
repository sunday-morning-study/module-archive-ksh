package com.study.modulearchive.controller;

import com.study.modulearchive.controller.dto.OrdersResponse;
import com.study.modulearchive.domain.Member;
import com.study.modulearchive.domain.Order;
import com.study.modulearchive.domain.item.Item;
import com.study.modulearchive.repository.OrderSearch;
import com.study.modulearchive.service.ItemService;
import com.study.modulearchive.service.MemberService;
import com.study.modulearchive.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final MemberService memberService;
    private final ItemService itemService;

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

        return ResponseEntity.ok(OrdersResponse.of(orders));
    }

    @PostMapping("/orders/{orderId}/cancel")
    public String cancelOrder(@PathVariable("orderId") Long orderId) {
        orderService.cancelOrder(orderId);
        return "redirect:/orders";
    }
}

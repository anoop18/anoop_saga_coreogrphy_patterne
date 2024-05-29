package org.saga.commons.order.controller;

import org.saga.commons.dto.OrderRequestDto;
import org.saga.commons.order.entity.PurchaseOrder;
import org.saga.commons.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
@Autowired
    private OrderService orderService;

@PostMapping("/create")
    public PurchaseOrder createOrder(@RequestBody OrderRequestDto orderRequestDto){
    return orderService.createOrder(orderRequestDto);
    }

    @GetMapping
    public List<PurchaseOrder> getAllOrders(){
    return orderService.getAllOrders();
    }
}

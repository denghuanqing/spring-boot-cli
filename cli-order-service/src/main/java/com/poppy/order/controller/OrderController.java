package com.poppy.order.controller;

import com.poppy.order.domain.Order;
import com.poppy.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author poppy
 * @date 2018/11/11 20:09
 */
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/order/{order_id}")
    public Order get(@PathVariable("order_id") String orderId) {
        return orderService.findById(orderId);
    }
}

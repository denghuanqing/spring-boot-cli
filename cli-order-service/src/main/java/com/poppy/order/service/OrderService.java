package com.poppy.order.service;

import com.poppy.item.entity.Item;
import com.poppy.order.domain.Order;
import com.poppy.order.domain.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author poppy
 * @date 2018/11/11 16:43
 */
@Service
public class OrderService {
    @Autowired
    ItemService itemService;

    static HashMap<String, Order> orderMap = new HashMap<>(16);

    static {
        Order order = new Order("1", 1L, new Date(), new Date());
        ArrayList<OrderDetail> items = new ArrayList<>();
        Item item = new Item();
        item.setId(1L);
        items.add(new OrderDetail(order.getOrderId(), item));

        Item item2 = new Item();
        item2.setId(2L);
        items.add(new OrderDetail(order.getOrderId(), item2));

        order.setOrderDetailList(items);
        orderMap.put(order.getOrderId(), order);
    }

    public Order findById(String orderId) {
        Order order = orderMap.get(orderId);
        List<OrderDetail> orderDetailList = order.getOrderDetailList();
        for (OrderDetail detail : orderDetailList) {
            // 远程调用商品服务
            Item item = itemService.findByIdByFeign(detail.getItem().getId());
            System.out.println("远程获取商品服务：{}" + item.toString());
            detail.setItem(item);
        }
        return order;
    }
}

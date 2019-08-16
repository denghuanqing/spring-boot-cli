package com.poppy.order.domain;

import com.poppy.item.entity.Item;

/**
 * @author poppy
 * @date 2018/11/11 16:35
 */
public class OrderDetail {
    private String orderId;
    private Item item = new Item();

    public OrderDetail(String orderId, Item item) {
        this.orderId = orderId;
        this.item = item;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}

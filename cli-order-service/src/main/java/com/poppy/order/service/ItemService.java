package com.poppy.order.service;

import com.poppy.order.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author poppy
 * @date 2018/11/11 16:08
 */
@Service
public class ItemService {

    @Autowired
    private DiscoveryClient discoveryClient;

    // 远程调用商品服务
    public Item findById(Long itemId) {
        List<ServiceInstance> instances = discoveryClient.getInstances("item-service");
        String host = instances.get(0).getHost();
        return new Item();
    }
}

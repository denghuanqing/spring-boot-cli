package com.poppy.order.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    @HystrixCommand(fallbackMethod = "findByIdFall")
    public Item findById(Long itemId) {
        List<ServiceInstance> instances = discoveryClient.getInstances("item-service");
        String host = instances.get(0).getHost();
        return new Item();
    }

    public Item findByIdFall(Long itemId) {
        return new Item(1L, "获取商品信息出错", "", "", "");

    }
}

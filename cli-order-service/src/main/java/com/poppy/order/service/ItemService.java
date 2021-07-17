package com.poppy.order.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import com.poppy.item.entity.Item;
import com.poppy.item.feign.ItemServiceApi;
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

    @Autowired
    private ItemServiceApi itemServiceApi;

    // 远程调用商品服务
    @Deprecated
    @HystrixCommand(fallbackMethod = "findByIdFall")
    public Item findByIdByHttp(Long itemId) {
        List<ServiceInstance> instances = discoveryClient.getInstances("item-service");
        // 手动在这里发送  http request
        String host = instances.get(0).getHost();
        return new Item();
    }

    @HystrixCommand(fallbackMethod = "findByIdFall")
    public List<Item> findListByFeign() {
        return itemServiceApi.list();
    }

    /**
     * 1.目标服务请求超时就会执行降级，走托底数据。
     * 2.一定时间内，异常请求比例达到阈值，启动熔断器，停止调用目标服务，直接返回托底数据。
     * 自动恢复机制，每5s尝试请求，成功后关闭熔断器。
     *
     * @param itemId
     * @return
     */
    public Item findByIdFall(Long itemId) {
        return new Item(1L, "获取商品信息出错", "", "", "");
    }

    /**
     * [关闭item-service模拟失败的情况]
     * 15s内6个请中，存在30%的失败率（2个失败） 执行熔断。
     * 熔断后25s内不在发起请求。保持熔断器打开状态。
     * 超出25s时间窗口后会尝试发起请求（测试好像是等待客户端请求），直到服务检测成功，才会关闭断路器。
     *
     * @param itemId
     * @return
     */
    @HystrixCommand(fallbackMethod = "findByIdFall", commandProperties = {
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD, value = "6"),
            @HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS, value = "10000"),
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE, value = "30"),
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS, value = "25000"),
    })
    public Item findByIdByFeign(Long itemId) {
        return itemServiceApi.findById(itemId);
    }
}

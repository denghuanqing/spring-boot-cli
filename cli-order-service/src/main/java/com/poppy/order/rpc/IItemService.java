package com.poppy.order.rpc;

import com.poppy.order.domain.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author poppy
 * @date 2018/11/11 22:29
 */
@FeignClient(value = "item-service")
public interface IItemService {

    @RequestMapping(value = "/item/{item_id}", method = RequestMethod.GET)
    Item findById(@PathVariable("item_id") Long itemId);
}

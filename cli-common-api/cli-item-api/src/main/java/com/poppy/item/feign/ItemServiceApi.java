package com.poppy.item.feign;

import com.poppy.item.entity.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @description:
 * @author: DENGHUANQING1
 * @create: 2019-08-16 17:02
 **/
@FeignClient(value = "item-service")
public interface ItemServiceApi {

    @RequestMapping(value = "/item/{item_id}", method = RequestMethod.GET)
    Item findById(@PathVariable("item_id") Long itemId);

}

package com.poppy.item.controller;

import com.poppy.item.domain.Item;
import com.poppy.item.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author poppy
 * @date 2018/11/11 16:19
 */
@RestController
public class ItemController {

    Logger logger = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    ItemService itemService;

    @RequestMapping("/item/{item_id}")
    public Item get(@PathVariable("item_id") long itemId) {
        logger.info("query Item Servie:{}",itemId);
        return itemService.findById(itemId);
    }
}

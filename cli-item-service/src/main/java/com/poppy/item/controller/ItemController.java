package com.poppy.item.controller;

import com.poppy.item.domain.Item;
import com.poppy.item.service.ItemService;
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
    @Autowired
    ItemService itemService;

    @RequestMapping("/item/{item_id}")
    public Item get(@PathVariable("item_id") long itemId) {
        return itemService.findById(itemId);
    }
}

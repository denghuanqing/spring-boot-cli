package com.poppy.item.service;

import com.poppy.item.domain.Item;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author poppy
 * @date 2018/11/11 16:08
 */
@Service
public class ItemService {
    private static HashMap<Long, Item> itemHashMap = new HashMap<>(16);

    static {
        itemHashMap.put(1L,new Item(1L,"商品详情1","商品图片1","商品描述1","商品价格1"));
        itemHashMap.put(2L,new Item(2L,"商品详情2","商品图片2","商品描述2","商品价格2"));
        itemHashMap.put(3L,new Item(3L,"商品详情3","商品图片3","商品描述3","商品价格3"));
        itemHashMap.put(4L,new Item(4L,"商品详情4","商品图片4","商品描述4","商品价格4"));
        itemHashMap.put(5L,new Item(5L,"商品详情5","商品图片5","商品描述5","商品价格5"));
        itemHashMap.put(6L,new Item(6L,"商品详情6","商品图片6","商品描述6","商品价格6"));
    }

    public Item findById(Long itemId){
        return itemHashMap.get(itemId);
    }
}

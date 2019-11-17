package com.poppy.item.controller;

import com.poppy.item.stream.producer.StreamMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: DENGHUANQING1
 * @create: 2019-11-17 22:06
 **/
@RestController
public class KafkaController {

    @Autowired
    private StreamMessageProducer streamMessageProducer;

    @RequestMapping("/kafka/test")
    public void test1(){
        streamMessageProducer.produceTest("this msg from poppy");
    }
}

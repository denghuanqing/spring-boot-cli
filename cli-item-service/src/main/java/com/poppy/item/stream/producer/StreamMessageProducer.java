//package com.poppy.item.stream.producer;
//
//import com.poppy.item.stream.StreamResource;
//import com.poppy.item.stream.consumer.StreamMessageConsumer;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.annotation.StreamListener;
//import org.springframework.messaging.support.MessageBuilder;
//
///**
// * @description: 消息的发送者
// * @author: DENGHUANQING1
// * @create: 2019-11-17 21:53
// **/
//public class StreamMessageProducer {
//
//    @Autowired
//    private StreamResource streamSource;
//
//    private final Logger logger = LoggerFactory.getLogger(StreamMessageProducer.class);
//
//    public void produceTest(String msg) {
//        logger.info("produce message : " + msg);
//        streamSource.output1().send(MessageBuilder.withPayload(msg).build());
//    }
//}

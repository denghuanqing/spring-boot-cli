package com.poppy.item.stream.consumer;

import com.poppy.item.stream.StreamResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * Spring cloud Stream 消费者
 */
public class StreamMessageConsumer {

    private final Logger logger = LoggerFactory.getLogger(StreamMessageConsumer.class);

    @StreamListener(StreamResource.INPUT_1)
    private void receive(String msg) {
        logger.info("receive message : " + msg);
    }

}

//package com.poppy.item.stream;
//
//import org.springframework.cloud.stream.annotation.Input;
//import org.springframework.cloud.stream.annotation.Output;
//import org.springframework.messaging.MessageChannel;
//import org.springframework.messaging.SubscribableChannel;
//
///**
// * spring cloud Stream 自定义通道
// */
//public interface StreamResource {
//
//    //接收队列1
//    String INPUT_1 = "test_in";
//    String OUT_1 = "test_out";
//
//    /**
//     * 订阅这个通道
//     * @return
//     */
//    @Input(StreamResource.INPUT_1)
//    SubscribableChannel input1();
//
//    /**
//     * 推送到这个通道
//     * @return
//     */
//    @Output(StreamResource.OUT_1)
//    MessageChannel output1();
//}

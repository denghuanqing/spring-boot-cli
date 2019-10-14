package com.poppy.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: DENGHUANQING1
 * @create: 2019-10-14 19:21
 **/
@RestController
public class TestController {
    @RequestMapping(value = "/products")
    public String getProductName() {
        return "Honey";
    }
}

package com.poppy.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @description:
 * @author: DENGHUANQING1
 * @create: 2019-10-15 16:29
 **/
public class PasswordEncoderTest {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("1q2w3e"));
    }
}

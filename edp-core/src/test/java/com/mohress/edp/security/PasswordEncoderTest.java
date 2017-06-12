package com.mohress.edp.security;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by youtao.wan on 2017/6/11.
 */
public class PasswordEncoderTest {

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Test
    public void testEncodePassword(){
        String password = "teacher";
        System.out.println(passwordEncoder.encode(password));
    }
}

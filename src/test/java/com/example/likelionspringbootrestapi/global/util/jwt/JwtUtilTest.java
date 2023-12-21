package com.example.likelionspringbootrestapi.global.util.jwt;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class JwtUtilTest {
    @Test
    @DisplayName("t1")
    void t1() {
        Map<String, String> data = Map.of("name", "홍길동", "age", "22");
        String jwtToken = JwtUtil.encode(data);

        System.out.println(jwtToken);

        assertThat(jwtToken).isNotNull();
    }
}

package com.demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// @EnableJpaAuditing // JPA Auditing 활성화 // 별도 파일로 이동 - 테스트 시 문제 때문.
@SpringBootApplication
public class Application {
    public static void main(String [] args) {
        SpringApplication.run(Application.class, args);
    }
}

package com.wndud0159.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JAP Auditing 활성화
@SpringBootApplication
public class SpringbootWebserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebserviceApplication.class, args);
    }

}

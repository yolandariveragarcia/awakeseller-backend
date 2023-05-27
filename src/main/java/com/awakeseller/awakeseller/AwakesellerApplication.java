package com.awakeseller.awakeseller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AwakesellerApplication {

    public static void main(final String[] args) {
        SpringApplication.run(AwakesellerApplication.class, args);
    }

}

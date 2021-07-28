package com.njpji.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.njpji.app.mapper")
public class MpdemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MpdemoApplication.class,args);
    }

}

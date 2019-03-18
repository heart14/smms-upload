package com.heart.smmsupload;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.heart.smmsupload.dao")
public class SmmsUploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmmsUploadApplication.class, args);
    }

}

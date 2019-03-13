package com.ibm.mosesboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ibm.mosesboot.user.mapper")
public class MosesbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MosesbootApplication.class, args);
    }

}


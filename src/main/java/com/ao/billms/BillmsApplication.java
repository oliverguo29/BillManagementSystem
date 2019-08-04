package com.ao.billms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.ao.billms.mapper")
@SpringBootApplication
public class BillmsApplication {

    public static void main(String[] args) {

        SpringApplication.run(BillmsApplication.class, args);
    }

}

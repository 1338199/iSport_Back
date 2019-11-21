package com.judge.pose;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.judge.pose.dao")
public class PoseApplication {

    public static void main(String[] args) {
        SpringApplication.run(PoseApplication.class, args);
    }

}

package com.example.templates.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.example.templates.generator.mapper")
public class MyBatisConfig {
}

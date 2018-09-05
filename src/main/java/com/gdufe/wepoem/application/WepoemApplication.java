package com.gdufe.wepoem.application;

import com.gdufe.wepoem.util.LogUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.gdufe.wepoem"})
@MapperScan("com.gdufe.wepoem.mapper")
public class WepoemApplication {

    public static void main(String[] args) {
        LogUtil.info("Start WebApplication ...");
        SpringApplication.run(WepoemApplication.class, args);
        LogUtil.info("WebApplication is running ...");
    }
}

package com.newsapi.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages="com.newsapi")
public class NewsapiApplication extends SpringBootServletInitializer implements WebApplicationInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(NewsapiApplication.class);
    }
    
   public static void main(String[] args) throws Exception {
        SpringApplication.run(NewsapiApplication.class, args);
    }
   
}
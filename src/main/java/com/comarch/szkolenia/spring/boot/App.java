package com.comarch.szkolenia.spring.boot;

import com.comarch.szkolenia.spring.boot.configuration.AppConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        //mateusz.bereda@comarch.com
        SpringApplication.run(AppConfiguration.class, args);
    }
}

package com.comarch.szkolenia.spring.boot.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
@ComponentScan("com.comarch.szkolenia.spring.boot")
public class AppConfiguration {

    @Value("${db.host}")
    private String dbHost;

    @Bean
    public Connection connection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                    this.dbHost,
                    "root",
                    "");
        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Nie dziala baza !");
        }

        return null;
    }
}

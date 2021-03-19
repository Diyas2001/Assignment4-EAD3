package com.example.assignment5_ead3.Config;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@ComponentScan(basePackages = "com.example.assignment5_ead3")
@PropertySource("application.properties")
@EnableJpaRepositories(basePackages = "com.example.assignment5_ead3.Repository")
public class Config {
}

package com.example.bean.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public UserConfig createUserBean(){
        return new UserConfig("Shri", 25);
    }
}

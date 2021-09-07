package com.tg.marketingpreferences.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

import java.util.Random;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean(name = "random")
    public Random createRandom(){
       return new Random();
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}

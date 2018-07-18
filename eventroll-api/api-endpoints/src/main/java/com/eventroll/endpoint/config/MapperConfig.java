package com.eventroll.endpoint.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: William Arustamyan
 * Date: 18/07/2018
 * Time: 7:57 AM
 */

@Configuration
public class MapperConfig {


    @Bean
    public ModelMapper createModelMapper() {
        return new ModelMapper();
    }
}

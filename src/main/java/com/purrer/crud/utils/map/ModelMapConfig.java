package com.purrer.crud.utils.map;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ModelMapConfig {
    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }
}

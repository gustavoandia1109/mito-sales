package com.mitocode.config;

import com.mitocode.dto.CategoryDTO;
import com.mitocode.model.Category;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean("defaultMapper")
    public ModelMapper defaultMapper() {
        return new ModelMapper();
    }

    @Bean("categoryMapper")
    public ModelMapper categoryMapper() {
        ModelMapper mapper = new ModelMapper();

        //Handle Missmatches
        //Lectura GET
        mapper.createTypeMap(Category.class, CategoryDTO.class)
                .addMapping(Category::getName, (dest, v) -> dest.setNameofCategory((String) v));

        //Escritura POST PUT
        mapper.createTypeMap(CategoryDTO.class, Category.class)
                .addMapping(CategoryDTO::getNameofCategory, (dest, v) -> dest.setName((String) v));

        return mapper;
    }
}

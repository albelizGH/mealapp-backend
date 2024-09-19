package com.alejobeliz.pentabyte.projects.mealapp.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    private final ObjectMapper objectMapper;

    public Mapper() {
        this.objectMapper = new ObjectMapper();
    }

    public <T> T map(Object objetoBase,Class<T> clase) {
        return objectMapper.convertValue(objetoBase, clase);
    }

}

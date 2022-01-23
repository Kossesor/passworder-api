package com.myself.passworder.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StringUtils {
    private static final ObjectMapper JSON_OBJECT_MAPPER = new ObjectMapper();

    public static String json(Object obj) {
        try {
            return JSON_OBJECT_MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}

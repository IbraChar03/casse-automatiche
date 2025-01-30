package com.example.demo.commons.mapper;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class LocalDateMapperConverter {

    public String asString(LocalDate date) {
        return date != null ? DateTimeFormatter.ofPattern("yyyy-MM-dd").format(date) : null;
    }

    public LocalDate asDate(String date) {
        try {
            return date != null ? LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd")) : null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

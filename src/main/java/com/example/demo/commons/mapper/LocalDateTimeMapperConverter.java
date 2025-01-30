package com.example.demo.commons.mapper;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class LocalDateTimeMapperConverter {

    public String asString(LocalDateTime date) {
        return date != null ? DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(date) : null;
    }

    public LocalDateTime asDate(String date) {
        try {
            return date != null ? LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).atStartOfDay() : null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

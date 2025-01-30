package com.example.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class ReceiptResponseDto {
    private Long id;
    private LocalDate emissionDate;
    private List<Long> articleIds;
}

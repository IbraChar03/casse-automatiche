package com.example.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PriceResponseDto {
    private Long id;
    private Double value;
    private String validityDateFrom;
    private Long articleId;
}

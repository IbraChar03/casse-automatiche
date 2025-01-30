package com.example.demo.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriceResponseDto {
    private Long id;
    private Double value;
    private String validityDate;
    private Long articleId;
}

package com.example.demo.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriceRequestDto {
    private Long id;
    private Double value;
    private String validityDate;
    private Long articleId;
}

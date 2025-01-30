package com.example.demo.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockRequestDto {
    private Long id;
    private Integer quantity;
    private String date;
    private Long articleId;
}

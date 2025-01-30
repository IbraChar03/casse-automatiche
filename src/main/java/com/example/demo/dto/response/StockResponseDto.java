package com.example.demo.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockResponseDto {
    private Long id;
    private Integer quantity;
    private String date;
    private Long articleId;
}

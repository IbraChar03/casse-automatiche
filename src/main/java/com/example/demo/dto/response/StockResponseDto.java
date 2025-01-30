package com.example.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StockResponseDto {
    private Long id;
    private Integer quantity;
    private String date;
    private Long articleId;
}

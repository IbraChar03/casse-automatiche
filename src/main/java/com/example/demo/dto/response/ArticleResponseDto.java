package com.example.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ArticleResponseDto {
    private Long id;
    private String name;
    private Double weight;
    private String unitOfMeasure;
    private String department;
}

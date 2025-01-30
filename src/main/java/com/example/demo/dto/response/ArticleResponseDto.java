package com.example.demo.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleResponseDto {
    private Long id;
    private String name;
    private Double weight;
    private String unitOfMeasure;
    private String department;
}

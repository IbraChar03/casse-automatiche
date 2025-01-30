package com.example.demo.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleRequestDto {
    private Long id;
    private String name;
    private Double weight;
    private String unitOfMeasure;
    private String department;
}

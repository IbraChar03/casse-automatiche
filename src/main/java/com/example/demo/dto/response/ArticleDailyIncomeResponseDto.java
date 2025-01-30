package com.example.demo.dto.response;

import com.example.demo.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ArticleDailyIncomeResponseDto {
    private Article article;
    private Long articleQuantitySold;
    private Double dailyIncome;

}

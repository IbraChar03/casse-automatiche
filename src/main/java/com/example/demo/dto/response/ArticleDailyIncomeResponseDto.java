package com.example.demo.dto.response;

import com.example.demo.entity.Article;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleDailyIncomeResponseDto {
    private Article article;
    private Long articleQuantitySold;
    private Long dailyIncome;

}

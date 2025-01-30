package com.example.demo.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ArticleListDailyIncomeResponseDto {
    private List<ArticleDailyIncomeResponseDto> articles;
}

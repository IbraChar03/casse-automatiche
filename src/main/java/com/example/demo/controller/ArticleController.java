package com.example.demo.controller;

import com.example.demo.dto.request.ArticleRequestDto;
import com.example.demo.dto.request.ArticlesDailyIncomeRequestDto;
import com.example.demo.dto.request.ReceiptDailyIncomeRequestDto;
import com.example.demo.dto.response.ArticleListDailyIncomeResponseDto;
import com.example.demo.dto.response.ArticleResponseDto;
import com.example.demo.entity.Article;
import com.example.demo.mapper.ArticleMapper;
import com.example.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleMapper articleMapper;

    @PostMapping
    public ResponseEntity<ArticleResponseDto> createArticle(@RequestBody ArticleRequestDto articleRequestDto) {
        Article article = articleService.addArticle(articleMapper.requestToEntity(articleRequestDto));
        return ResponseEntity.ok(articleMapper.entityToResponse(article));
    }
    @PostMapping("/articles-income")
    public ResponseEntity<ArticleListDailyIncomeResponseDto> calculateArticlesDailyIncome(@RequestBody ArticlesDailyIncomeRequestDto articlesDailyIncomeRequestDto) {
        var list = articleService.calculateArticlesDailyIncome(articlesDailyIncomeRequestDto);
        return ResponseEntity.ok(list);
    }
}

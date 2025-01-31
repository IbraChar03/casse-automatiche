package com.example.demo.controller;

import com.example.demo.dto.request.ArticleRequestDto;
import com.example.demo.dto.request.DateRequestDto;
import com.example.demo.dto.response.ArticleListDailyIncomeResponseDto;
import com.example.demo.dto.response.ArticleResponseDto;
import com.example.demo.dto.response.DepartmentsIncomeResponseDto;
import com.example.demo.entity.Article;
import com.example.demo.mapper.ArticleMapper;
import com.example.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/articles-daily-income")
    public ResponseEntity<ArticleListDailyIncomeResponseDto> calculateArticlesDailyIncome(@RequestParam String date) {
        var list = articleService.calculateArticlesDailyIncome(date);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/departments-daily-income")
    public ResponseEntity<DepartmentsIncomeResponseDto> calculateDepartmentsDailyIncome(@RequestParam String date) {
        var list = articleService.calculateDepartmentsDailyIncome(date);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/departments-yearly-income")
    public ResponseEntity<DepartmentsIncomeResponseDto> calculateDepartmentsYearlyIncome(@RequestParam String year) {
        var list = articleService.calculateDepartmentsYearlyIncome(year);
        return ResponseEntity.ok(list);
    }
}

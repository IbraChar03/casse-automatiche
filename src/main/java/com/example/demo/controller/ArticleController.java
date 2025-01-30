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
    public ResponseEntity<ArticleListDailyIncomeResponseDto> calculateArticlesDailyIncome(@RequestBody DateRequestDto dateRequestDto) {
        var list = articleService.calculateArticlesDailyIncome(dateRequestDto);
        return ResponseEntity.ok(list);
    }
    @PostMapping("/departments-income")
    public ResponseEntity<DepartmentsIncomeResponseDto> calculateDepartmentsDailyIncome(@RequestBody DateRequestDto dateRequestDto) {
        var list = articleService.calculateDepartmentsDailyIncome(dateRequestDto);
        return ResponseEntity.ok(list);
    }
}

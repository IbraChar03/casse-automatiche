package com.example.demo.service;

import com.example.demo.dto.request.ArticlesDailyIncomeRequestDto;
import com.example.demo.dto.request.StockDateRequestDto;
import com.example.demo.dto.response.ArticleListDailyIncomeResponseDto;
import com.example.demo.entity.Article;
import com.example.demo.entity.Receipt;
import com.example.demo.entity.Stock;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ReceiptRepository receiptRepository;


    public Article addArticle(Article article) {
        return articleRepository.save(article);
    }
    public ArticleListDailyIncomeResponseDto calculateArticlesDailyIncome(ArticlesDailyIncomeRequestDto articlesDailyIncomeRequestDto) {
        return null;
    }



}

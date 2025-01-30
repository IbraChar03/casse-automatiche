package com.example.demo.service;

import com.example.demo.dto.request.ArticlesDailyIncomeRequestDto;
import com.example.demo.dto.request.StockDateRequestDto;
import com.example.demo.dto.response.ArticleDailyIncomeResponseDto;
import com.example.demo.dto.response.ArticleListDailyIncomeResponseDto;
import com.example.demo.entity.Article;
import com.example.demo.entity.Receipt;
import com.example.demo.entity.Stock;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.repository.PriceRepository;
import com.example.demo.repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ReceiptRepository receiptRepository;
    @Autowired
    private PriceRepository priceRepository;


    public Article addArticle(Article article) {
        return articleRepository.save(article);
    }
    public ArticleListDailyIncomeResponseDto calculateArticlesDailyIncome(ArticlesDailyIncomeRequestDto articlesDailyIncomeRequestDto) {
        ArticleListDailyIncomeResponseDto articleListDailyIncomeResponseDto = new ArticleListDailyIncomeResponseDto();
        articleListDailyIncomeResponseDto.setArticles(new ArrayList<>());
        LocalDate date = LocalDate.parse(articlesDailyIncomeRequestDto.getDate());
        List<Receipt> receipts = receiptRepository.findAllByEmissionDate(date);

        List<Long> allArticleIds = receipts.stream()
                .flatMap(receipt -> receipt.getArticleIds().stream())
                .toList();

        allArticleIds.stream()
                .distinct()
                .forEach(articleId -> {
                    Long articleSold = allArticleIds.stream()
                            .filter(id -> id.equals(articleId))
                            .count();
                    var price = priceRepository.findTopByArticleIdAndValidityDateLessThanEqualOrderByValidityDateDesc(
                            articleId, date).orElseThrow();
                    Double dailyIncome =price.getValue() * articleSold;
                    var article = articleRepository.findById(articleId).orElseThrow();
                    articleListDailyIncomeResponseDto.getArticles().add(new ArticleDailyIncomeResponseDto(article,articleSold,dailyIncome));
                });
        return articleListDailyIncomeResponseDto;
    }



}

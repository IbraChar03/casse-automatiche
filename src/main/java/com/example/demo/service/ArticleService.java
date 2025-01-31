package com.example.demo.service;

import com.example.demo.dto.request.DateRequestDto;
import com.example.demo.dto.response.ArticleDailyIncomeResponseDto;
import com.example.demo.dto.response.ArticleListDailyIncomeResponseDto;
import com.example.demo.dto.response.DepartmentsIncomeResponseDto;
import com.example.demo.entity.Article;
import com.example.demo.entity.Receipt;
import com.example.demo.entity.Stock;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.repository.PriceRepository;
import com.example.demo.repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ArticleListDailyIncomeResponseDto calculateArticlesDailyIncome(String dateString) {
        ArticleListDailyIncomeResponseDto articleListDailyIncomeResponseDto = new ArticleListDailyIncomeResponseDto(new ArrayList<>());
        LocalDate date = LocalDate.parse(dateString);
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
                    var price = priceRepository.findTopByArticleIdAndValidityDateFromLessThanEqualOrderByValidityDateFromDesc(
                            articleId, date).orElseThrow();
                    Double dailyIncome = price.getValue() * articleSold;
                    var article = articleRepository.findById(articleId).orElseThrow();
                    articleListDailyIncomeResponseDto.getArticles().add(new ArticleDailyIncomeResponseDto(article,articleSold,dailyIncome));
                });
        return articleListDailyIncomeResponseDto;
    }
    public DepartmentsIncomeResponseDto calculateDepartmentsDailyIncome(String dateString) {
        LocalDate date = LocalDate.parse(dateString);
        List<Receipt> receipts = receiptRepository.findAllByEmissionDate(date);

        Map<String, Double> departmentIncomeMap = new HashMap<>();

        receipts.stream()
                .forEach(receipt -> receipt.getArticleIds().forEach(articleId -> {
                    var article = articleRepository.findById(articleId).orElseThrow();
                    var price = priceRepository.findTopByArticleIdAndValidityDateFromLessThanEqualOrderByValidityDateFromDesc(
                            articleId, date).orElseThrow();
                    long quantitySold = receipt.getArticleIds().stream().filter(id -> id.equals(articleId)).count();
                    double totalIncome = price.getValue() * quantitySold;
                    departmentIncomeMap.merge(article.getDepartment(), totalIncome, Double::sum);
                }));
        return new DepartmentsIncomeResponseDto(departmentIncomeMap);
    }

    public DepartmentsIncomeResponseDto calculateDepartmentsYearlyIncome(String year) {
        List<Receipt> receipts = receiptRepository.findAllByEmissionDateYear(Integer.valueOf(year));
        Map<String, Double> departmentIncomeMap = new HashMap<>();
        receipts.stream()
                .forEach(receipt -> receipt.getArticleIds().forEach(articleId -> {
                    var article = articleRepository.findById(articleId).orElseThrow();
                    var price = priceRepository.findTopByArticleIdAndValidityDateFromLessThanEqualOrderByValidityDateFromDesc(
                            articleId, receipt.getEmissionDate()).orElseThrow();
                    long quantitySold = receipt.getArticleIds().stream().filter(id -> id.equals(articleId)).count();
                    double totalIncome = price.getValue() * quantitySold;
                    departmentIncomeMap.merge(article.getDepartment(), totalIncome, Double::sum);
                }));

        return new DepartmentsIncomeResponseDto(departmentIncomeMap);
    }

}

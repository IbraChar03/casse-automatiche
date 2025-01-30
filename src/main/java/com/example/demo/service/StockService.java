package com.example.demo.service;

import com.example.demo.dto.request.DateRequestDto;
import com.example.demo.entity.Receipt;
import com.example.demo.entity.Stock;
import com.example.demo.repository.ReceiptRepository;
import com.example.demo.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StockService {
    @Autowired
    private ReceiptRepository receiptRepository;
    @Autowired
    private StockRepository stockRepository;

    public void calculateStockEndOfDay(DateRequestDto dateRequestDto) {
        LocalDate date = LocalDate.parse(dateRequestDto.getDate());
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

                    Stock stock = stockRepository.findByArticleIdAndDate(articleId, date)
                            .orElseThrow();

                    stock.setQuantity((int) (stock.getQuantity() - articleSold));

                    stockRepository.save(stock);
                });
    }
}

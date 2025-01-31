package com.example.demo.service;

import com.example.demo.commons.exception.GenericErrorException;
import com.example.demo.dto.request.DateRequestDto;
import com.example.demo.entity.Article;
import com.example.demo.entity.Barcode;
import com.example.demo.entity.Price;
import com.example.demo.entity.Receipt;
import com.example.demo.mapper.ReceiptMapper;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.repository.BarcodeRepository;
import com.example.demo.repository.PriceRepository;
import com.example.demo.repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReceiptService {
    @Autowired
    private ReceiptRepository receiptRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private BarcodeRepository barcodeRepository;
    @Autowired
    private PriceRepository priceRepository;

    public Receipt createReceipt(Receipt receipt){
        receipt.setEmissionDate(LocalDate.now());
        return receiptRepository.save(receipt);
    }

    public void addArticleToReceipt(String barcodeString, String receiptId) {
        Barcode barcode = barcodeRepository.findByCode(barcodeString)
                .orElseThrow();
        if(barcode.getValidityStartDate().isAfter(LocalDate.now()) || barcode.getValidityEndDate().isBefore(LocalDate.now())){
            throw new GenericErrorException("invalid barcode");
        }

        Article article = articleRepository.findById(barcode.getArticleId())
                .orElseThrow();

        Receipt receipt = receiptRepository.findById(Long.valueOf(receiptId))
                .orElseThrow();

        receipt.getArticleIds().add(article.getId());

        receiptRepository.save(receipt);
    }

    public double calculateDailyIncome(String dateString) {
        LocalDate date = LocalDate.parse(dateString);
        List<Receipt> receipts = receiptRepository.findAllByEmissionDate(date);
        return receipts.stream()
                .mapToDouble(this::calculateTotalReceipt)
                .sum();
    }

    private double calculateTotalReceipt(Receipt receipt) {
        return receipt.getArticleIds().stream()
                .mapToDouble(articleId -> {
                    var price = priceRepository.findTopByArticleIdAndValidityDateFromLessThanEqualOrderByValidityDateFromDesc(
                            articleId, receipt.getEmissionDate());

                    return price.map(Price::getValue).orElse(0.0);
                })
                .sum();
    }
}

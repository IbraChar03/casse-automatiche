package com.example.demo.controller;

import com.example.demo.dto.request.*;
import com.example.demo.dto.response.ArticleResponseDto;
import com.example.demo.dto.response.ReceiptResponseDto;
import com.example.demo.entity.Article;
import com.example.demo.mapper.ArticleMapper;
import com.example.demo.mapper.ReceiptMapper;
import com.example.demo.service.ArticleService;
import com.example.demo.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/receipt")
public class ReceiptController {
    @Autowired
    private ReceiptService receiptService;
    @Autowired
    private ReceiptMapper receiptMapper;

    @PostMapping
    public ResponseEntity<ReceiptResponseDto> createReceipt(@RequestBody ReceiptRequestDto receiptRequestDto) {
        var receipt = receiptService.createReceipt(receiptMapper.requestToEntity(receiptRequestDto));
        return ResponseEntity.ok(receiptMapper.entityToResponse(receipt));
    }
    @PostMapping("/add-article/{id}")
    public ResponseEntity<Void> addArticleReceipt(@RequestBody ReceiptBarcodeRequestDto receiptBarcodeRequestDto, @PathVariable String id) {
        receiptService.addArticleToReceipt(receiptBarcodeRequestDto.getBarcode(),id);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/daily-income")
    public ResponseEntity<Double> calculateDailyIncome(@RequestBody DateRequestDto dateRequestDto) {
        double income = receiptService.calculateDailyIncome(dateRequestDto);
        return ResponseEntity.ok(income);
    }

}
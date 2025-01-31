package com.example.demo.controller;

import com.example.demo.dto.request.DateRequestDto;
import com.example.demo.dto.request.ReceiptRequestDto;
import com.example.demo.dto.response.ReceiptResponseDto;
import com.example.demo.service.ArticleService;
import com.example.demo.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockService stockService;
    @GetMapping("/calculate")
    public ResponseEntity<Void> calculateStockEndOfDay(@RequestParam String date) {
        stockService.calculateStockEndOfDay(date);
        return ResponseEntity.ok().build();
    }
}

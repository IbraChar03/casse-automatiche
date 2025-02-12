package com.example.demo.repository;

import com.example.demo.entity.Barcode;
import com.example.demo.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface StockRepository  extends JpaRepository<Stock, Long> {
    Optional<Stock> findByArticleIdAndDate(Long articleId, LocalDate date);
}

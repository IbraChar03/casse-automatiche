package com.example.demo.repository;

import com.example.demo.entity.Price;
import com.example.demo.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
    Optional<Price> findTopByArticleIdAndValidityDateLessThanEqualOrderByValidityDateDesc(Long articleId, LocalDate validityDate);
}

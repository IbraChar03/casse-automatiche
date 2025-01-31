package com.example.demo.repository;

import com.example.demo.entity.Article;
import com.example.demo.entity.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
    List<Receipt> findAllByEmissionDate(LocalDate emissionDate);
    @Query("SELECT r FROM Receipt r WHERE YEAR(r.emissionDate) = :year")
    List<Receipt> findAllByEmissionDateYear(@Param("year") Integer year);
}

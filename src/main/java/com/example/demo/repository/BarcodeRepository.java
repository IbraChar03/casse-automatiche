package com.example.demo.repository;

import com.example.demo.entity.Article;
import com.example.demo.entity.Barcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BarcodeRepository extends JpaRepository<Barcode, Long> {
    Optional<Barcode> findByCode(String code);
}

package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double weight;
    private String unitOfMeasure;
    private String department;

    @OneToMany(targetEntity = Barcode.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "article_id")
    private List<Barcode> barcodes;

    @OneToMany(targetEntity = Price.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "article_id")
    private List<Price> prices;

    @OneToMany(targetEntity = Stock.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "article_id")
    private List<Stock> stocks;
}

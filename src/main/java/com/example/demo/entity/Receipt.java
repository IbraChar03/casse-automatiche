package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate emissionDate;

    @ElementCollection
    @CollectionTable(name = "receipt_articles", joinColumns = @JoinColumn(name = "receipt_id"))
    @Column(name = "article_id")
    private List<Long> articleIds;

}

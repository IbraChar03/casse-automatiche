package com.example.demo.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ReceiptRequestDto {
    private Long id;
    private List<Long> articleIds;
}

package com.example.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BarcodeResponseDto {
    private Long id;
    private String code;
    private String validityStartDate;
    private String validityEndDate;
    private String articleId;
}

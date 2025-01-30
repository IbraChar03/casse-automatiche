package com.example.demo.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BarcodeResponseDto {
    private Long id;
    private String code;
    private String validityStartDate;
    private String validityEndDate;
    private String articleId;
}

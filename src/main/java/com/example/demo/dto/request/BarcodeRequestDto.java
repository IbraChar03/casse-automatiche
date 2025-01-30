package com.example.demo.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BarcodeRequestDto {
    private Long id;
    private String code;
    private String validityStartDate;
    private String validityEndDate;
    private String articleId;
}

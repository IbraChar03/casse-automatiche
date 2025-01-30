package com.example.demo.mapper;

import com.example.demo.commons.mapper.LocalDateMapperConverter;
import com.example.demo.commons.mapper.LocalDateTimeMapperConverter;
import com.example.demo.dto.request.ReceiptRequestDto;
import com.example.demo.dto.request.StockRequestDto;
import com.example.demo.dto.response.ReceiptResponseDto;
import com.example.demo.dto.response.StockResponseDto;
import com.example.demo.entity.Receipt;
import com.example.demo.entity.Stock;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = LocalDateMapperConverter.class)
public interface ReceiptMapper {

    Receipt requestToEntity(ReceiptRequestDto request);
    ReceiptResponseDto entityToResponse(Receipt receipt);
}


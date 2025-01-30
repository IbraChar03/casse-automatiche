package com.example.demo.mapper;

import com.example.demo.commons.mapper.LocalDateMapperConverter;
import com.example.demo.dto.request.StockRequestDto;
import com.example.demo.dto.response.StockResponseDto;
import com.example.demo.entity.Stock;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = LocalDateMapperConverter.class)
public interface StockMapper {

    Stock requestToEntity(StockRequestDto request);
    StockResponseDto entityToResponse(Stock stock);
}

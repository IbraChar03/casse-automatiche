package com.example.demo.mapper;

import com.example.demo.commons.mapper.LocalDateMapperConverter;
import com.example.demo.dto.request.PriceRequestDto;
import com.example.demo.dto.response.PriceResponseDto;
import com.example.demo.entity.Price;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", uses = LocalDateMapperConverter.class)
public interface PriceMapper {

    Price requestToEntity(PriceRequestDto request);
    PriceResponseDto entityToResponse(Price price);
}
package com.example.demo.mapper;

import com.example.demo.commons.mapper.LocalDateMapperConverter;
import com.example.demo.dto.request.BarcodeRequestDto;
import com.example.demo.dto.response.BarcodeResponseDto;
import com.example.demo.entity.Barcode;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = LocalDateMapperConverter.class)
public interface BarcodeMapper {

    Barcode requestToEntity(BarcodeRequestDto request);

    BarcodeResponseDto entityToResponse(Barcode barcode);
}

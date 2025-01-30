package com.example.demo.mapper;

import com.example.demo.dto.request.ArticleRequestDto;
import com.example.demo.dto.response.ArticleResponseDto;
import com.example.demo.entity.Article;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ArticleMapper  {

    Article requestToEntity(ArticleRequestDto request);

    ArticleResponseDto entityToResponse(Article article);
}

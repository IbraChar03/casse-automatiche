package com.example.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
@Getter
@Setter
@AllArgsConstructor
public class DepartmentsIncomeResponseDto {
    private Map<String, Double> departmentsIncome;
}

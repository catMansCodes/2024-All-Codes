package org.catmanscodes.eta.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(
        description = "Expense DTO -Data Transfer Object to transfer data between clint & server"
)
public record ExpenseDto(
        Long id,
        @Schema(description = "Expense Amount")
        BigDecimal amount,
        @Schema(description = "Expense Date")
        LocalDate expenseDate,
        @Schema(description = "Associated Expense Category i.e FOOD, CLOTHS, MOVIE")
        CategoryDto categoryDto
) {
}

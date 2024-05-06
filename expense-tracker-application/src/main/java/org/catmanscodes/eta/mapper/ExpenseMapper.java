package org.catmanscodes.eta.mapper;

import org.catmanscodes.eta.dto.CategoryDto;
import org.catmanscodes.eta.dto.ExpenseDto;
import org.catmanscodes.eta.entity.Category;
import org.catmanscodes.eta.entity.Expense;

public class ExpenseMapper {

    public static Expense mapToExpense(ExpenseDto expenseDto) {

        Category category = new Category();
        category.setId(expenseDto.categoryDto().id());

        return new Expense(
                expenseDto.id(),
                expenseDto.amount(),
                expenseDto.expenseDate(),
                category
        );
    }

    public static ExpenseDto mapTOExpenseDto(Expense expense) {

        return new ExpenseDto(
                expense.getId(),
                expense.getAmount(),
                expense.getExpenseDate(),
                new CategoryDto(
                        expense.getCategory().getId(),
                        expense.getCategory().getName()
                )
        );
    }
}

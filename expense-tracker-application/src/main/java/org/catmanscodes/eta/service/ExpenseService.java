package org.catmanscodes.eta.service;

import org.catmanscodes.eta.dto.ExpenseDto;
import org.catmanscodes.eta.entity.Expense;

import java.util.List;

public interface ExpenseService {

    ExpenseDto createExpense(ExpenseDto expenseDto);

    ExpenseDto updateExpense(Long id, ExpenseDto expenseDto);

    ExpenseDto getExpenseById(Long expenseId);

    List<ExpenseDto> getAllExpense();

    void deleteExpense(Long expenseId);
}

package org.catmanscodes.eta.service;

import lombok.AllArgsConstructor;
import org.catmanscodes.eta.dto.ExpenseDto;
import org.catmanscodes.eta.entity.Category;
import org.catmanscodes.eta.entity.Expense;
import org.catmanscodes.eta.exception.ResourceNotFoundException;
import org.catmanscodes.eta.mapper.ExpenseMapper;
import org.catmanscodes.eta.repository.CategoryRepository;
import org.catmanscodes.eta.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseRepository expenseRepository;
    private CategoryRepository categoryRepository;

    @Override
    public ExpenseDto createExpense(ExpenseDto expenseDto) {

        Expense expense = ExpenseMapper.mapToExpense(expenseDto);

        Expense savedExpense = expenseRepository.save(expense);

        return ExpenseMapper.mapTOExpenseDto(savedExpense);
    }


    @Override
    public ExpenseDto getExpenseById(Long expenseId) {

        Expense expense = expenseRepository.findById(expenseId).orElseThrow(() -> new ResourceNotFoundException("No Expense found"));

        return ExpenseMapper.mapTOExpenseDto(expense);
    }

    @Override
    public List<ExpenseDto> getAllExpense() {

        List<Expense> expenseList = expenseRepository.findAll();

        List<ExpenseDto> expenseDtoList = expenseList.stream()
                .map((expense) -> ExpenseMapper.mapTOExpenseDto(expense)).collect(Collectors.toList());

        return expenseDtoList;
    }


    @Override
    public ExpenseDto updateExpense(Long expenseId, ExpenseDto expenseDto) {

        Expense expense = expenseRepository.findById(expenseId).orElseThrow(() -> new ResourceNotFoundException("No Expense found"));

        //Update the amount
        expense.setAmount(expenseDto.amount());
        //Update the expense date
        expense.setExpenseDate(expenseDto.expenseDate());

        //update category
        if (expenseDto.categoryDto() != null) {

            // get category by id
            Category category = categoryRepository.findById(expenseDto.categoryDto().id()).orElseThrow(() -> new ResourceNotFoundException("No Category Id found"));
            expense.setCategory(category);
        }

        //update expense entity

        Expense savedExpense = expenseRepository.save(expense);

        return ExpenseMapper.mapTOExpenseDto(savedExpense);
    }

    @Override
    public void deleteExpense(Long expenseId) {

        Expense expense = expenseRepository.findById(expenseId).orElseThrow(() -> new ResourceNotFoundException("No Expense found"));

        expenseRepository.deleteById(expenseId);
    }

}

package org.catmanscodes.eta.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.catmanscodes.eta.dto.ExpenseDto;
import org.catmanscodes.eta.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(
        name = "EXPENSE CRUD REST APIs",
        description = "Expense REST Apis : Create Expense, Read Expense & Expense List, Update Expense, Delete Expense, "
)
@AllArgsConstructor
@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private ExpenseService expenseService;

    // 1. Create Expense Rest API
    @Operation(
            summary = "Create Expense Rest API",
            description = "Create new Expense from database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP STATUS CODE 200 CREATED"
    )
    @PostMapping("/create")
    public ResponseEntity<ExpenseDto> createExpense(@RequestBody ExpenseDto expenseDto) {

        return new ResponseEntity<ExpenseDto>(expenseService.createExpense(expenseDto), HttpStatus.CREATED);
    }

    // 2. Update Expense Rest API
    @Operation(
            summary = "Update Expense Rest API",
            description = "Update Expense by id from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS CODE 200 OK"
    )
    @PutMapping("/{id}/update")
    public ResponseEntity<ExpenseDto> updateExpense(@PathVariable("id") Long id, @RequestBody ExpenseDto expenseDto) {

        return ResponseEntity.ok(expenseService.updateExpense(id, expenseDto));
    }

    // 3. Get Expense by ID REST API
    @Operation(
            summary = "Get Expense Rest API",
            description = "Get Expense by id from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS CODE 200 OK"
    )
    @GetMapping("/{id}")
    public ResponseEntity<ExpenseDto> getExpenseDto(@PathVariable("id") Long id) {

        return ResponseEntity.ok(expenseService.getExpenseById(id));
    }

    // 4. Get All Expense REST API
    @Operation(
            summary = "Get All Expense Rest API",
            description = "Get All Expense from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS CODE 200 OK"
    )
    @GetMapping
    public ResponseEntity<List<ExpenseDto>> expenseList() {

        return ResponseEntity.ok(expenseService.getAllExpense());
    }

    // 5. Delete Expense REST API

    @Operation(
            summary = "Delete Expense Rest API",
            description = "Delete Expense by id from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS CODE 200 OK"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable("id") Long id){

        expenseService.deleteExpense(id);

        return ResponseEntity.ok("Expense deleted successfully.");
    }
}

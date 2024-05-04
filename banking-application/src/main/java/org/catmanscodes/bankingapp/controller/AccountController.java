package org.catmanscodes.bankingapp.controller;

import org.catmanscodes.bankingapp.dto.AccountDto;
import org.catmanscodes.bankingapp.dto.TransactionDto;
import org.catmanscodes.bankingapp.dto.TransferFundDto;
import org.catmanscodes.bankingapp.entity.Account;
import org.catmanscodes.bankingapp.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // Create Account REST API

    @PostMapping("/create")
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto) {

        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    // GET Account REST API
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountDtoById(@PathVariable("id") Long id) {

        return ResponseEntity.ok(accountService.getAccountDtoById(id));
    }

    // DEPOSIT Amount REST API

    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> depositAmount(@PathVariable("id") Long id, @RequestBody Map<String, Double> request) {

        Double amount = request.get("amount");

        return ResponseEntity.ok(accountService.depositAmount(id, amount));
    }

    // Withdraw Amount REST API

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdrawBalance(@PathVariable("id") Long id, @RequestBody Map<String, Double> request) {

        Double balance = request.get("balance");

        return ResponseEntity.ok(accountService.withDrawAmount(id, balance));
    }

    // Get All Accounts REST API

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts(){

        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    // DELETE Account REST API

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable("id") Long id){
        accountService.deleteAccountById(id);

        return ResponseEntity.ok("Account Deleted successfully");
    }

    // Fund transfer REST API

    @PostMapping("/transfer")
    public ResponseEntity<String> fundTransfer(@RequestBody TransferFundDto transferFundDto){

        accountService.transferFund(transferFundDto);

        return ResponseEntity.ok("Amount Transfer successful");
    }

    // TRANSACTION REST API by Account id

    @GetMapping("/{id}/transactions")
    public ResponseEntity<List<TransactionDto>> getTransactionHistory(@PathVariable("id") Long accountId){

        return ResponseEntity.ok(accountService.getTransactionByAccountId(accountId));
    }

}

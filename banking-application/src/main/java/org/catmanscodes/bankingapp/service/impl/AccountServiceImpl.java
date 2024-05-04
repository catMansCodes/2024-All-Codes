package org.catmanscodes.bankingapp.service.impl;

import org.catmanscodes.bankingapp.dto.AccountDto;
import org.catmanscodes.bankingapp.dto.TransactionDto;
import org.catmanscodes.bankingapp.dto.TransferFundDto;
import org.catmanscodes.bankingapp.entity.Account;
import org.catmanscodes.bankingapp.entity.Transaction;
import org.catmanscodes.bankingapp.exception.AccountException;
import org.catmanscodes.bankingapp.mapper.AccountMapper;
import org.catmanscodes.bankingapp.mapper.TransactionMapper;
import org.catmanscodes.bankingapp.repository.AccountRepository;
import org.catmanscodes.bankingapp.repository.TransactionRepository;
import org.catmanscodes.bankingapp.service.AccountService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    private TransactionRepository transactionRepository;

    private static final String TRANSACTION_TYPE_DEPOSIT = "DEPOSIT";
    private static final String TRANSACTION_TYPE_WITHDRAW = "WITHDRAW";
    private static final String TRANSACTION_TYPE_TRANSFER = "TRANSFER";


    public AccountServiceImpl(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {

        Account account = AccountMapper.mapToAccount(accountDto);

        Account savedAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountDtoById(Long id) {

        Account account = accountRepository.findById(id).orElseThrow(() -> new AccountException("Account not found."));

        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto depositAmount(Long id, double amount) {

        Account account = accountRepository.findById(id).orElseThrow(() -> new AccountException("Account not found."));

        double total = account.getBalance() + amount;

        account.setBalance(total);
        Account saveAccount = accountRepository.save(account);

        Transaction transaction = new Transaction();
        transaction.setAccountId(id);
        transaction.setAmount(amount);
        transaction.setTransactionType(TRANSACTION_TYPE_DEPOSIT);
        transaction.setTimestamp(LocalDateTime.now());

        transactionRepository.save(transaction);

        return AccountMapper.mapToAccountDto(saveAccount);
    }

    @Override
    public AccountDto withDrawAmount(Long id, double amount) {

        Account account = accountRepository.findById(id).orElseThrow(() -> new AccountException("Account not found."));

        if (amount > account.getBalance()) {
            throw new AccountException("Not minimum balance to withdraw this amount");
        }

        double balance = account.getBalance() - amount;
        account.setBalance(balance);
        accountRepository.save(account);

        Transaction transaction = new Transaction();
        transaction.setAccountId(id);
        transaction.setAmount(amount);
        transaction.setTransactionType(TRANSACTION_TYPE_WITHDRAW);
        transaction.setTimestamp(LocalDateTime.now());

        transactionRepository.save(transaction);

        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public List<AccountDto> getAllAccounts() {

        List<Account> accountList = accountRepository.findAll();

        List<AccountDto> accountDtoList = accountList.stream().map((account) -> AccountMapper.mapToAccountDto(account))
                .collect(Collectors.toList());

        return accountDtoList;
    }

    @Override
    public void deleteAccountById(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new AccountException("Account not found."));

        accountRepository.deleteById(id);
    }

    @Override
    public void transferFund(TransferFundDto transferFundDto) {

        //1. Retrieve account of sender
        Account fromAccount = accountRepository.findById(transferFundDto.fromAccountId())
                .orElseThrow(() -> new AccountException("Account not found."));

        //2. Retrieve account of receiver
        Account toAccount = accountRepository.findById(transferFundDto.toAccountId())
                .orElseThrow(() -> new AccountException("Account not found."));

        //3. Debit the amount from sender
        if (fromAccount.getBalance() < transferFundDto.amount()) {
            throw new AccountException("Insufficient amount to transfer");
        }

        fromAccount.setBalance(fromAccount.getBalance() - transferFundDto.amount());

        //4. Credited the amount to receiver
        toAccount.setBalance(toAccount.getBalance() + transferFundDto.amount());

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

        Transaction transaction = new Transaction();
        transaction.setAccountId(fromAccount.getId());
        transaction.setAmount(transferFundDto.amount());
        transaction.setTransactionType(TRANSACTION_TYPE_TRANSFER);
        transaction.setTimestamp(LocalDateTime.now());

        transactionRepository.save(transaction);

    }

    @Override
    public List<TransactionDto> getTransactionByAccountId(Long accountId) {

        List<Transaction> transactionList = transactionRepository.findByAccountIdOrderByTimestampDesc(accountId);

        return transactionList.stream()
                .map((transaction -> TransactionMapper.toTransactionDto(transaction)))
                .collect(Collectors.toList());
    }


}

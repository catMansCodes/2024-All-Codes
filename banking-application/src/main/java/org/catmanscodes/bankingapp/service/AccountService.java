package org.catmanscodes.bankingapp.service;

import org.catmanscodes.bankingapp.dto.AccountDto;
import org.catmanscodes.bankingapp.dto.TransactionDto;
import org.catmanscodes.bankingapp.dto.TransferFundDto;

import java.util.List;


public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountDtoById(Long id);

    AccountDto depositAmount(Long id, double amount);

    AccountDto withDrawAmount(Long id, double amount);

    List<AccountDto> getAllAccounts();

    void deleteAccountById(Long id);

    void transferFund(TransferFundDto transferFundDto);

    List<TransactionDto> getTransactionByAccountId(Long accountId);

}

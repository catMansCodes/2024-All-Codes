package org.catmanscodes.bankingapp.mapper;

import org.catmanscodes.bankingapp.dto.TransactionDto;
import org.catmanscodes.bankingapp.entity.Transaction;

public class TransactionMapper {

    public static TransactionDto toTransactionDto(Transaction transaction) {
        return new TransactionDto(
                transaction.getId(),
                transaction.getAccountId(),
                transaction.getAmount(),
                transaction.getTransactionType(),
                transaction.getTimestamp()
        );
    }
}

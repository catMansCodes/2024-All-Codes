package org.catmanscodes.bankingapp.dto;

//import lombok.*;

//@Data
//@AllArgsConstructor
//public class AccountDto {
//    private Long id;
//    private String accountHolderName;
//    private double balance;
//}

public record AccountDto(
        Long id,
        String accountHolderName,
        double balance) {

}

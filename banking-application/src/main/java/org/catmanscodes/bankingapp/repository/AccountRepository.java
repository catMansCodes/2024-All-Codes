package org.catmanscodes.bankingapp.repository;

import org.catmanscodes.bankingapp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}

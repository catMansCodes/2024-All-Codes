package org.catmanscodes.eta.repository;

import org.catmanscodes.eta.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}

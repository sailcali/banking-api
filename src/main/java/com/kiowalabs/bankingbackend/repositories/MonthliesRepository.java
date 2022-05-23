package com.kiowalabs.bankingbackend.repositories;

import com.kiowalabs.bankingbackend.models.MonthlyExpenses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MonthliesRepository extends JpaRepository<MonthlyExpenses, Long> {
    List<MonthlyExpenses> findByNameContaining(String name);
}
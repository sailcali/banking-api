package com.kiowalabs.bankingbackend.repositories;

import com.kiowalabs.bankingbackend.models.BankBalances;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.time.LocalDate;

public interface BalancesRepository extends JpaRepository<BankBalances, Long> {
    List<BankBalances> findTopByOrderByIdDesc();
}
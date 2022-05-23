package com.kiowalabs.bankingbackend.repositories;

import com.kiowalabs.bankingbackend.models.MSCPayroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MSCPayrollRepository extends JpaRepository<MSCPayroll, Long> {
    List<MSCPayroll> findByYear(long year);
}
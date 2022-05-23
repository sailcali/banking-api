package com.kiowalabs.bankingbackend.repositories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.kiowalabs.bankingbackend.models.AnnualExpenses;

public interface AnnualsRepository extends JpaRepository<AnnualExpenses, Long> {
    List<AnnualExpenses> findByNameContaining(String name);
}
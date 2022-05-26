package com.kiowalabs.bankingbackend.controllers;


import com.kiowalabs.bankingbackend.models.BankBalances;
import com.kiowalabs.bankingbackend.repositories.BalancesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/banking-api/")
public class BalancesController {
    @Autowired
    BalancesRepository balancesRepository;

//    @GetMapping("/msc-payroll")
//    public ResponseEntity<List<MonthlyExpenses>> getAllMSCPayroll(@RequestParam(required = false) String name) {
//        try {
//            List<MonthlyExpenses> monthlies = new ArrayList<MonthlyExpenses>();
//            if (name == null)
//                mscPayrollRepository.findAll().forEach(monthlies::add);
//            else
//                mscPayrollRepository.findByNameContaining(name).forEach(monthlies::add);
//            if (monthlies.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(monthlies, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @GetMapping("/bank-balances")
    public ResponseEntity<BankBalances> getRecentBalances() {
        List<BankBalances> balances = balancesRepository.findTopByOrderByIdDesc();
        if (balances.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(balances.get(0), HttpStatus.OK);
        }
    }

    @PostMapping("/bank-balances")
    public ResponseEntity<BankBalances> addBalances(@RequestBody BankBalances balances) {
        try {
            BankBalances _balances = balancesRepository
                    .save(new BankBalances(balances.getAmex(), balances.getNfcu(), balances.getCoinbase(),
                            balances.getChaseMortgage(), balances.getDate()));
            return new ResponseEntity<>(_balances, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


//    @PutMapping("/msc-payroll/{id}")
//    public ResponseEntity<MSCPayroll> updatePayroll(@PathVariable("id") long id, @RequestBody MSCPayroll payroll) {
//        Optional<MSCPayroll> payrollData = mscPayrollRepository.findById(id);
//        if (payrollData.isPresent()) {
//            MSCPayroll _payroll = payrollData.get();
//            _payroll.setCpr(payroll.getCpr());
//            _payroll.setYear(payroll.getYear());
//            _payroll.setPayDate(payroll.getPayDate());
//            _payroll.setNetPay(payroll.getNetPay());
//            _payroll.setGrossPay(payroll.getGrossPay());
//            return new ResponseEntity<>(mscPayrollRepository.save(_payroll), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
}
//    @DeleteMapping("/monthly-expenses/{id}")
//    public ResponseEntity<HttpStatus> deletePayroll(@PathVariable("id") long id) {
//        try {
//            mscPayrollRepository.deleteById(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//}

//    @GetMapping("/tutorials/published")
//    public ResponseEntity<List<AnnualExpenses>> findByPublished() {
//        try {
//            List<AnnualExpenses> tutorials = annualsRepository.findByPublished(true);
//            if (tutorials.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(tutorials, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//}
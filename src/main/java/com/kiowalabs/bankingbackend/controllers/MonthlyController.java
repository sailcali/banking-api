package com.kiowalabs.bankingbackend.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.kiowalabs.bankingbackend.models.MonthlyExpenses;
import com.kiowalabs.bankingbackend.repositories.MonthliesRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/banking-api/")
public class MonthlyController {
    @Autowired
    MonthliesRepository monthliesRepository;

    @GetMapping("/monthly-expenses")
    public ResponseEntity<List<MonthlyExpenses>> getAllMonthlies(@RequestParam(required = false) String name) {
        try {
            List<MonthlyExpenses> monthlies = new ArrayList<MonthlyExpenses>();
            if (name == null)
                monthliesRepository.findAll().forEach(monthlies::add);
            else
                monthliesRepository.findByNameContaining(name).forEach(monthlies::add);
            if (monthlies.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(monthlies, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/monthly-expenses/{id}")
    public ResponseEntity<MonthlyExpenses> getAnnualById(@PathVariable("id") long id) {
        Optional<MonthlyExpenses> monthlyData = monthliesRepository.findById(id);
        if (monthlyData.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(monthlyData.get(), HttpStatus.OK);
        }
    }
    @PostMapping("/monthly-expenses")
    public ResponseEntity<MonthlyExpenses> createAnnual(@RequestBody MonthlyExpenses monthly) {
        try {
            MonthlyExpenses _monthly = monthliesRepository
                    .save(new MonthlyExpenses(monthly.getName(), monthly.getAmount(), monthly.getDueDay(), monthly.isEssential(),
                            monthly.getAutopayBank(), monthly.getRemarks()));
            return new ResponseEntity<>(_monthly, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/monthly-expenses/{id}")
    public ResponseEntity<MonthlyExpenses> updateMonthly(@PathVariable("id") long id, @RequestBody MonthlyExpenses monthly) {
        Optional<MonthlyExpenses> monthlyData = monthliesRepository.findById(id);
        if (monthlyData.isPresent()) {
            MonthlyExpenses _monthly = monthlyData.get();
            _monthly.setName(monthly.getName());
            _monthly.setAmount(monthly.getAmount());
            _monthly.setDueDay(monthly.getDueDay());
            _monthly.setRemarks(monthly.getRemarks());
            _monthly.setAutopayBank(monthly.getAutopayBank());
            _monthly.setEssential(monthly.isEssential());
            return new ResponseEntity<>(monthliesRepository.save(_monthly), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/monthly-expenses/{id}")
    public ResponseEntity<HttpStatus> deleteMonthly(@PathVariable("id") long id) {
        try {
            monthliesRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

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
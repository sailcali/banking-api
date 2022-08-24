package com.kiowalabs.bankingbackend.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kiowalabs.bankingbackend.models.AnnualExpenses;
import com.kiowalabs.bankingbackend.repositories.AnnualsRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/banking-api/")
public class AnnualsController {
    @Autowired
    AnnualsRepository annualsRepository;

    @GetMapping("/annuals")
    public ResponseEntity<List<AnnualExpenses>> getAllAnnuals(@RequestParam(required = false) String name) {
        try {
            List<AnnualExpenses> annuals = new ArrayList<AnnualExpenses>();
            if (name == null)
                annuals.addAll(annualsRepository.findAll());
            else
                annuals.addAll(annualsRepository.findByNameContaining(name));
            if (annuals.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(annuals, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/annuals/{id}")
    public ResponseEntity<AnnualExpenses> getAnnualById(@PathVariable("id") long id) {
        Optional<AnnualExpenses> annualData = annualsRepository.findById(id);
        if (annualData.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(annualData.get(), HttpStatus.OK);
        }
    }
    @PostMapping("/annuals")
    public ResponseEntity<AnnualExpenses> createAnnual(@RequestBody AnnualExpenses annual) {
        try {
            AnnualExpenses _annual = annualsRepository
                    .save(new AnnualExpenses(annual.getName(), annual.getAmount(), annual.getDueDate(), annual.isEssential(),
                            annual.getAutopayBank(), annual.getPeriod(), annual.getRemarks()));
            return new ResponseEntity<>(_annual, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/annuals/{id}")
    public ResponseEntity<AnnualExpenses> updateAnnual(@PathVariable("id") long id, @RequestBody AnnualExpenses annual) {
        Optional<AnnualExpenses> annualData = annualsRepository.findById(id);
        if (annualData.isPresent()) {
            AnnualExpenses _annual = annualData.get();
            _annual.setName(annual.getName());
            _annual.setAmount(annual.getAmount());
            _annual.setDueDate(annual.getDueDate());
            _annual.setRemarks(annual.getRemarks());
            _annual.setAutopayBank(annual.getAutopayBank());
            _annual.setPeriod(annual.getPeriod());
            _annual.setEssential(annual.isEssential());
            return new ResponseEntity<>(annualsRepository.save(_annual), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/annuals/{id}")
    public ResponseEntity<HttpStatus> deleteAnnual(@PathVariable("id") long id) {
        try {
            annualsRepository.deleteById(id);
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
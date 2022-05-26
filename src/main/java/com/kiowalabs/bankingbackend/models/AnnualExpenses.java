package com.kiowalabs.bankingbackend.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "annual_expenses")
public class AnnualExpenses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "amount")
    private float amount;
    @Column(name = "due_date")
    private LocalDate dueDate;
    @Column(name = "essential")
    private boolean essential;
    @Column(name = "autopay_bank")
    private String autopayBank;
    @Column(name = "period")
    private short period;
    @Column(name = "remarks")
    private String remarks;

    public AnnualExpenses() {
    }
    public AnnualExpenses(String name, float amount, LocalDate dueDate, boolean essential,
                          String autopayBank, short period, String remarks) {
        this.name = name;
        this.amount = amount;
        this.dueDate = dueDate;
        this.essential = essential;
        this.autopayBank = autopayBank;
        this.period = period;
        this.remarks = remarks;
    }
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getAmount() {
        return amount;
    }
    public void setAmount(float amount) {
        this.amount = amount;
    }
    public boolean isEssential() {
        return essential;
    }
    public void setEssential(boolean isEssential) {
        this.essential = isEssential;
    }
    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }
    public String getAutopayBank() { return autopayBank; }
    public void setAutopayBank(String autopayBank) { this.autopayBank = autopayBank;}
    public short getPeriod() { return period; }
    public void setPeriod(short period) { this.period = period;}
    public String getRemarks() {return remarks;}
    public void setRemarks(String remarks) { this.remarks = remarks;}

    @Override
    public String toString() {
        return "Annual Expense [id=" + id + ", name=" + name + ", amount=" + amount +
                ", due date=" + dueDate + ", remarks=" + remarks +"]";
    }
}
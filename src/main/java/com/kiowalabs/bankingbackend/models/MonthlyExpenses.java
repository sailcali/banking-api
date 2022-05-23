package com.kiowalabs.bankingbackend.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "monthly_expenses")
public class MonthlyExpenses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "amount")
    private float amount;
    @Column(name = "due_day")
    private byte dueDay;
    @Column(name = "essential")
    private boolean essential;
    @Column(name = "autopay_bank")
    private String autopayBank;
    @Column(name = "remarks")
    private String remarks;

    public MonthlyExpenses() {
    }
    public MonthlyExpenses(String name, float amount, byte dueDay, boolean essential,
                           String autopayBank, String remarks) {
        this.name = name;
        this.amount = amount;
        this.dueDay = dueDay;
        this.essential = essential;
        this.autopayBank = autopayBank;
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
    public byte getDueDay() { return dueDay; }
    public void setDueDay(byte dueDay) { this.dueDay = dueDay; }
    public String getAutopayBank() { return autopayBank; }
    public void setAutopayBank(String autopayBank) { this.autopayBank = autopayBank;}
    public String getRemarks() {return remarks;}
    public void setRemarks(String remarks) { this.remarks = remarks;}

    @Override
    public String toString() {
        return "Monthly Expense [id=" + id + ", name=" + name + ", amount=" + amount +
                ", due on day=" + dueDay + ", remarks=" + remarks +"]";
    }
}
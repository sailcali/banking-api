package com.kiowalabs.bankingbackend.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bank_balances")
public class BankBalances {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "balance_seq")
    private long id;
    @Column(name = "amex")
    private float amex;
    @Column(name = "nfcu")
    private float nfcu;
    @Column(name = "coinbase")
    private float coinbase;
    @Column(name = "chase_mortgage")
    private float chaseMortgage;
    @Column(name = "date")
    private LocalDate date;

    public BankBalances() {
    }
    public BankBalances(float amex, float nfcu, float coinbase, float chaseMortgage, LocalDate date) {
        this.amex = amex;
        this.nfcu = nfcu;
        this.coinbase = coinbase;
        this.chaseMortgage = chaseMortgage;
        this.date = date;
    }

    public long getId() {
        return id;
    }
    public float getAmex() {
        return amex;
    }
    public void setAmex(float amex) {
        this.amex = amex;
    }
    public float getNfcu() {
        return nfcu;
    }
    public void setNfcu(float nfcu) {
        this.nfcu = nfcu;
    }
    public float getCoinbase() {
        return coinbase;
    }
    public void setCoinbase(float coinbase) { this.coinbase = coinbase; }
    public float getChaseMortgage() { return chaseMortgage; }
    public void setChaseMortgage(float chaseMortgage) { this.chaseMortgage = chaseMortgage; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date;}

    @Override
    public String toString() {
        return "Bank Balances [id=" + id + ", Date=" + date + ", NFCU=" + nfcu +
                ", amex=" + amex + ", coinbase=" + coinbase + ", Chase Mortgage=" + chaseMortgage + "]";
    }
}
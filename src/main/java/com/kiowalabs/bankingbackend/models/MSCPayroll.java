package com.kiowalabs.bankingbackend.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "msc_payroll")
public class MSCPayroll {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "cpr")
    private byte cpr;
    @Column(name = "year")
    private long year;
    @Column(name = "pay_date")
    private Date payDate;
    @Column(name = "net_pay")
    private float netPay;
    @Column(name = "gross_pay")
    private float grossPay;

    public MSCPayroll() {
    }
    public MSCPayroll(byte cpr, long year, Date payDate, float netPay, float grossPay) {
        this.cpr = cpr;
        this.year = year;
        this.payDate = payDate;
        this.netPay = netPay;
        this.grossPay = grossPay;
    }
    public long getId() {
        return id;
    }
    public byte getCpr() {
        return cpr;
    }
    public void setCpr(byte cpr) {
        this.cpr = cpr;
    }
    public long getYear() {
        return year;
    }
    public void setYear(long year) {
        this.year = year;
    }
    public Date getPayDate() {
        return payDate;
    }
    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }
    public float getNetPay() { return netPay; }
    public void setNetPay(float netPay) { this.netPay = netPay; }
    public float getGrossPay() { return grossPay; }
    public void setGrossPay(float grossPay) { this.grossPay = grossPay;}

    @Override
    public String toString() {
        return "Payroll [id=" + id + ", CPR=" + cpr + "-" + year +
                ", pay date=" + payDate + ", net pay=" + netPay +"]";
    }
}
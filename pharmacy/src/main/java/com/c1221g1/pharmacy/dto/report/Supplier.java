package com.c1221g1.pharmacy.dto.report;

public class Supplier {
    private int id;
    private String supplierName;
    private double total;
    private double deposit;
    private double balance;

    public Supplier() {
    }

    public Supplier(int id, String supplierName, double total, double deposit, double balance) {
        this.id = id;
        this.supplierName = supplierName;
        this.total = total;
        this.deposit = deposit;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String name) {
        this.supplierName = name;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

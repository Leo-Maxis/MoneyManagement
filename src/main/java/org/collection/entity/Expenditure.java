package org.collection.entity;

import java.io.Serializable;
import java.util.Date;

public class Expenditure implements Serializable {
    private int id;
    private String name;
    private double amount;
    private String note;
    private int type;
    private Date expenditureDate;

    public Expenditure() {

    }

    public Expenditure(int id, String name, float amount, String note, int type, Date expenditureDate) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.note = note;
        this.type = type;
        this.expenditureDate = expenditureDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getExpenditureDate() {
        return expenditureDate;
    }

    public void setExpenditureDate(Date expenditureDate) {
        this.expenditureDate = expenditureDate;
    }
}

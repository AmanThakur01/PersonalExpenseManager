package com.mycompany.pem.domain;

import java.sql.Date;

/*
 * @author amanm
 */
public class Budget {
//    `from`, `to`, `amount`, `personalCare`, `transportational`, `rent`, `food`, `miscellaneous`, `bills`

    private Date from;
    private Date to;
    private Integer amount;
    private Integer personalCare;
    private Integer transportational;
    private Integer rent;
    private Integer food;
    private Integer miscellaneous;
    private Integer bills;
    private Integer sr;

    public Integer getSr() {
        return sr;
    }

    public void setSr(Integer sr) {
        this.sr = sr;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getPersonalCare() {
        return personalCare;
    }

    public void setPersonalCare(Integer personalCare) {
        this.personalCare = personalCare;
    }

    public Integer getTransportational() {
        return transportational;
    }

    public void setTransportational(Integer transportational) {
        this.transportational = transportational;
    }

    public Integer getRent() {
        return rent;
    }

    public void setRent(Integer rent) {
        this.rent = rent;
    }

    public Integer getFood() {
        return food;
    }

    public void setFood(Integer food) {
        this.food = food;
    }

    public Integer getMiscellaneous() {
        return miscellaneous;
    }

    public void setMiscellaneous(Integer miscellaneous) {
        this.miscellaneous = miscellaneous;
    }

    public Integer getBills() {
        return bills;
    }

    public void setBills(Integer bills) {
        this.bills = bills;
    }

}

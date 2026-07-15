package com.gymbooking;

public class Reservation {
    private int id;
    private String customerName;
    private String dateTime;

    public Reservation(int id, String customerName, String dateTime) {
        this.id = id;
        this.customerName = customerName;
        this.dateTime = dateTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getId() {
        return id;
    }

    public String getDateTime() {
        return dateTime;
    }

}

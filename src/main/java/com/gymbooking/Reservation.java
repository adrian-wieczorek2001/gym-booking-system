package com.gymbooking;

public class Reservation {
    private int id;
    private Member member;
    private String dateTime;

    public Reservation(int id, Member member, String dateTime) {
        this.id = id;
        this.member = member;
        this.dateTime = dateTime;
    }

    public Member getMember() {
        return member;
    }

    public int getId() {
        return id;
    }

    public String getDateTime() {
        return dateTime;
    }

}

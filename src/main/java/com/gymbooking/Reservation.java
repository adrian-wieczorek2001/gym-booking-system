package com.gymbooking;

import java.time.LocalDate;

public class Reservation {
    private int id;
    private Member member;
    private LocalDate dateTime;

    public Reservation(int id, Member member, LocalDate dateTime) {
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

    public LocalDate getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Member: " + member.getName() + ", Date: " + dateTime;
    }

}

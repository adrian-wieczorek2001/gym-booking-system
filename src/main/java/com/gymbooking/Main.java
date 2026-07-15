package com.gymbooking;

public class Main {
    public static void main(String[] args) {

        Member member = new Member("Adrian", 24, null);
        Reservation reservation = new Reservation(1, member, "15.07.2026");


        System.out.println(reservation.getMember().getName());




    }
}

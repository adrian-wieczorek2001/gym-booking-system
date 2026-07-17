package com.gymbooking;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Member member1 = new Member("Adrian", 24, MembershipType.ANNUAL);
        Member member2 = new Member("Bartosz", 22, MembershipType.QUARTERLY);
        Reservation reservation1 = new Reservation(1, member1, "15.07.2026");
        Reservation reservation2 = new Reservation(2, member2, "16.07.2026");

        Scanner scanner = new Scanner(System.in);

        System.out.println(reservation1.getMember().getName());

        GymBookingService reservations = new GymBookingService();

        reservations.addReservation(reservation1);
        reservations.addReservation(reservation2);

        for (Reservation reservation : reservations.getAllReservations()) {
            System.out.println(reservation.getId());
            System.out.println(reservation.getMember().getName());
            System.out.println(reservation.getDateTime());
        }

        System.out.println("Delete reservation: (give id) ");
        int number = scanner.nextInt();

        reservations.removeReservation(number);

        for (Reservation reservation : reservations.getAllReservations()) {
            System.out.println(reservation);
        }

        for (Reservation reservation : reservations.findReservationsByMember("Adrian")) {
            System.out.println(reservation);
        }


    }
}

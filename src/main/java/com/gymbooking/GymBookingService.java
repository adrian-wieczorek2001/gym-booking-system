package com.gymbooking;

import java.util.ArrayList;

public class GymBookingService {
    private ArrayList<Reservation> reservations;

    public GymBookingService() {
        this.reservations = new ArrayList<>();
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public ArrayList<Reservation> getAllReservations() {
        return reservations;
    }

    public void removeReservation(int id) {

        boolean found = false;

        for (int i = 0; i < reservations.size(); i++) {
            if (reservations.get(i).getId() == id) {
                reservations.remove(i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Id not found");
        }
    }

    public ArrayList<Reservation> findReservationsByMember(String memberName) {

        ArrayList<Reservation> newReservationList = new ArrayList<>();

        for (int i = 0; i < reservations.size(); i++) {
            if (reservations.get(i).getMember().getName().equals(memberName)) {
                newReservationList.add(reservations.get(i));
            }
        }

        return newReservationList;
    }



}

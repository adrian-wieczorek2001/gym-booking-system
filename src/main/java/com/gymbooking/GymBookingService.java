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
        for (int i = 0; i < reservations.size(); i++) {
            if (reservations.get(i).getId() == id) {
                reservations.remove(i);
            }
        }
    }



}

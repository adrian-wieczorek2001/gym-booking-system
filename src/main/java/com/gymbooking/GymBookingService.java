package com.gymbooking;

import java.time.LocalDate;
import java.util.ArrayList;

public class GymBookingService {
    private ArrayList<Reservation> reservations;
    private int nextId = 1;

    public GymBookingService() {
        this.reservations = new ArrayList<>();
    }


    /**
     * Adds a reservation to the list with an automatically generated id.
     *  @param member the member making the reservation
     *  @param dateTime the date of the reservation
     */
    public void addReservation(Member member, LocalDate dateTime) {

        if (dateTime.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("You cannot make a reservation for a date in the past. " +
                    "Please, enter correct date");
        }

        Reservation reservation = new Reservation(nextId, member, dateTime);

        reservations.add(reservation);
        nextId++;
    }


    /**
     * Returns all reservations from the list.
     * @return list of all reservations
     */
    public ArrayList<Reservation> getAllReservations() {
        return reservations;
    }


    /**
     * Removes a reservation from the list
     * @param id the id of the reservation to be removed
     */
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

    /**
     * Finds all reservations for a given member
     * @param memberName the name of the member
     * @return list of reservations belonging to the member
     */
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

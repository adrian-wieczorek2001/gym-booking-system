package com.gymbooking;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GymBookingService {
    private ArrayList<Reservation> reservations;
    private ArrayList<Member> members;
    private HashMap<LocalDate, Integer> possibleReservations;
    private int nextId = 1;
    private int nextMemberId = 1;
    private static final int MAX_CAPACITY = 20;

    public GymBookingService() {
        this.reservations = new ArrayList<>();
        this.possibleReservations = new HashMap<>();
        this.members = new ArrayList<>();
    }

    public void registerMember(Member member) {
        members.add(member);
        nextMemberId++;
    }

    public Member findMemberById(int id) {

        for (Member member : members) {
            if (id == member.getMemberId()) {
                return member;
            }
        }

            return null;
    }

    public int getNextMemberId() {
        return nextMemberId;
    }

    /**
     * Adds a reservation to the list with an automatically generated id.
     *  @param member the member making the reservation
     *  @param dateTime the date of the reservation
     */
    public void addReservation(Member member, LocalDate dateTime) {

        if (possibleReservations.containsKey(dateTime) &&
                possibleReservations.get(dateTime) >= MAX_CAPACITY) {
            throw new IllegalStateException("All possible spaces are already booked");
        }
        if (dateTime.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("You cannot make a reservation for a date in the past. " +
                    "Please, enter correct date");
        }

        Reservation reservation = new Reservation(nextId, member, dateTime);

        reservations.add(reservation);

        if (!possibleReservations.containsKey(dateTime)) {
            possibleReservations.put(dateTime, 1);
        } else {
            possibleReservations.put(dateTime, possibleReservations.get(dateTime) + 1);
        }

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
                LocalDate date = reservations.get(i).getDateTime();
                possibleReservations.put(date, possibleReservations.get(date) - 1);
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

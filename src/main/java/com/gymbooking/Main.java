package com.gymbooking;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static void showMenu(GymBookingService gymBookingService, Scanner scanner) {

        int choice = 0;

        while (true) {
            try {
                System.out.println("What would you like to do: " +
                        "\n1. Add reservations" +
                        "\n2. Show all reservation" +
                        "\n3. Delete reservation" +
                        "\n4. Find reservations by member name" +
                        "\n5. Exit");
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Wrong number! Please, try again!");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1: {

                    System.out.println("Type a name of member: ");
                    String name = scanner.nextLine();

                    MembershipType membershipType = null;

                    while (membershipType == null) {
                        System.out.println("Enter a membership type: ");
                        String input = scanner.next();

                        try {
                            membershipType = MembershipType.valueOf(input.toUpperCase());
                        } catch (IllegalArgumentException e) {
                            System.out.println("Wrong type of membership. Please, try again!");
                        }
                    }

                    int age = 0;

                    System.out.println("Enter member age:  ");
                    while (age == 0) {
                        try {
                            age = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("It's not correct age. Please, try again!");
                            scanner.nextLine();
                        }
                    }

                    Member member = new Member(name, age, membershipType);


                    int id = 0;

                    System.out.println("Enter a ID of reservation: ");
                    while (id == 0) {
                        try {
                            id = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("It's not correct form for ID. Please, use number!");
                            scanner.nextLine();
                        }
                    }

                    System.out.println("Enter a date for a reservation: ");
                    String dateTime = scanner.next();

                    Reservation reservation = new Reservation(id, member, dateTime);

                    gymBookingService.addReservation(reservation);
                    break;

                }

                case 2:
                    System.out.println("All reservations: ");

                    for (Reservation reservation : gymBookingService.getAllReservations()) {
                        System.out.println(reservation);
                    }

                    break;

                case 3: {

                    int id = 0;

                    System.out.println("Enter a ID of reservation: ");
                    while (id == 0) {
                        try {
                            id = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("It's not correct form for ID. Please, use number!");
                            scanner.nextLine();
                        }
                    }

                    gymBookingService.removeReservation(id);
                    break;
                }

                case 4:
                    System.out.println("Please, enter a member to show list of reservation: ");
                    String memberName = scanner.nextLine();
                    System.out.println("Your reservations: ");
                    for (Reservation reservation : gymBookingService.findReservationsByMember(memberName)) {
                        System.out.println(reservation);
                    };
                    break;

                case 5:
                    System.out.println("Ending of program...");
                    System.exit(0);

            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GymBookingService gymBookingService = new GymBookingService();
        showMenu(gymBookingService, scanner);

    }
}

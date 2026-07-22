package com.gymbooking;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Member createMember(Scanner scanner, int memberId) {

        while (true) {

            String name = null;

            while (name == null) {

                try {
                    System.out.println("Type a name of member: ");
                    name = scanner.nextLine();

                    if (name.isEmpty() || !name.matches("[a-zA-Z ]+")) {
                        System.out.println("Name must contain letters only");
                        name = null;
                    }

                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }


            }

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
            while (age < 15) {
                try {
                    age = scanner.nextInt();

                    if (age < 15) {
                        System.out.println("Age cannot be less than 15");
                        age = 0;
                    }

                } catch (InputMismatchException e) {
                    System.out.println("It's not correct age. Please, try again!");
                    scanner.nextLine();
                }
            }

            scanner.nextLine();

            try {
                return new Member(memberId, name, age, membershipType);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("Please, try again!");
            }
        }
    }

    private static void showMenu(GymBookingService gymBookingService, Scanner scanner) {

        int choice = 0;

        while (true) {
            try {
                System.out.println("What would you like to do: " +
                        "\n1. Register a member" +
                        "\n2. Add reservations" +
                        "\n3. Show all reservation" +
                        "\n4. Delete reservation" +
                        "\n5. Find reservations by member name" +
                        "\n6. Exit");
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Wrong number! Please, try again!");
                scanner.nextLine();
                continue;
            }

            switch (choice) {

                case 1: {
                    Member member = createMember(scanner, gymBookingService.getNextMemberId());
                    gymBookingService.registerMember(member);
                    break;
                }

                case 2: {

                    Member member = null;

                    while (true) {
                        System.out.println("Enter your member id: ");

                        int id = 0;

                        try {
                            id = scanner.nextInt();
                            member = gymBookingService.findMemberById(id);
                            if (member != null) {
                                break;
                            } else {
                                System.out.println("This member doesn't exist");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Your id must be a number. Try again!");
                        }

                    }


                    while (true) {
                        LocalDate dateTime = null;
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

                        while (dateTime == null) {
                            try {
                                System.out.println("Enter a date for a reservation (dd.mm.yyyy): ");
                                dateTime = LocalDate.parse(scanner.next(), formatter);
                            } catch (DateTimeParseException e) {
                                System.out.println("It's not a date format. please, try again!");
                            }
                        }

                        try {
                            gymBookingService.addReservation(member, dateTime);
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                }

                case 3:
                    System.out.println("All reservations: ");

                    for (Reservation reservation : gymBookingService.getAllReservations()) {
                        System.out.println(reservation);
                    }

                    break;

                case 4: {

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

                case 5:
                    System.out.println("Please, enter a member to show list of reservation: ");
                    String memberName = scanner.nextLine();
                    System.out.println("Your reservations: ");
                    for (Reservation reservation : gymBookingService.findReservationsByMember(memberName)) {
                        System.out.println(reservation);
                    };
                    break;

                case 6:
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

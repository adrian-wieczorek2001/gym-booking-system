# Gym Booking System

A console-based gym reservation management system built in Java. Allows registering members, booking and cancelling reservations, and tracking daily capacity.

## Features

- Register gym members with validated name, age, and membership type
- Book reservations for a specific date, with automatic capacity checks
- Cancel existing reservations by ID
- View all reservations and remaining available spaces per date
- Search reservations by member name
- View all registered members

## Tech Stack

- Java 26
- Maven
- Core Java collections (`ArrayList`, `HashMap`)
- `java.time` API (`LocalDate`, `DateTimeFormatter`)

## Project Structure

```
src/main/java/com/gymbooking/
├── Main.java                  # Console menu and user interaction
├── GymBookingService.java     # Business logic: reservations, members, capacity tracking
├── Member.java                 # Member entity (name, age, id, membership type)
├── MembershipType.java         # Enum: SINGLE, MONTHLY, QUARTERLY, ANNUAL
└── Reservation.java             # Reservation entity (id, member, date)
```

## How It Works

- Each gym date has a maximum capacity of 20 reservations.
- `GymBookingService` tracks the number of booked spots per date in a `HashMap<LocalDate, Integer>`, so capacity can be checked in constant time without scanning the full reservation list.
- Member IDs and reservation IDs are auto-generated and managed internally by the service.
- Input validation is handled at the menu level (`Main`), while business rules (e.g. rejecting overbooked dates or past dates) are enforced in `GymBookingService` via exceptions.

## Running the Project

```bash
mvn compile
mvn exec:java -Dexec.mainClass="com.gymbooking.Main"
```

## Example Menu

```
What would you like to do:
1. Register a member
2. Add reservations
3. Show all reservations
4. Delete reservation
5. Find reservations by member name
6. Show list of all members
7. Exit
```

## Status

This is a learning project built incrementally while studying Java backend development. Current focus: core Java, collections, and clean console-based architecture. Planned next steps include persistence (file-based or database) and unit tests.

## Author

Adrian Wieczorek
package com.gymbooking;

public class Member {
    private String name;
    private int age;
    private MembershipType membershipType;

    public Member(String name, int age, MembershipType membershipType) {

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if (!name.matches("[a-zA-Z ]+")) {
            throw new IllegalArgumentException("Name must contain letters only");
        }

        if (age < 15) {
            throw new IllegalArgumentException("Age cannot be less than 15");
        }

        this.name = name;
        this.age = age;
        this.membershipType = membershipType;

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }
}

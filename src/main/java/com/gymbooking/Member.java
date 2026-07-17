package com.gymbooking;

public class Member {
    private String name;
    private int age;
    private MembershipType membershipType;

    public Member(String name, int age, MembershipType membershipType) {
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

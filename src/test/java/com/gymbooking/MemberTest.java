package com.gymbooking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MemberTest {

    @Test
    void createMemberWithAgeBelow15ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Member(1, "Adrian", 10, MembershipType.ANNUAL);
        });
    }
}

package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumbersTest {

    @Test
    void matchWith() {
        Numbers computer = new Numbers(4, 2, 5);

        Result result = computer.matchWith(new Numbers(1, 2, 3));
        assertEquals(result, Result.of(1, 0));

        result = computer.matchWith(new Numbers(4, 5, 6));
        assertEquals(result, Result.of(1, 1));

        result = computer.matchWith(new Numbers(7, 8, 9));
        assertEquals(result, Result.of(0, 0));
    }
}
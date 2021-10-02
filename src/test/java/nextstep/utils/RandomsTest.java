package nextstep.utils;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Repeatable;

import static org.junit.jupiter.api.Assertions.*;

class RandomsTest {

    private final int START_INCLUSIVE = 0;
    private final int END_INCLUSIVE = 9;

    @Test
    public void testPickNumberInRange() {
        int newNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
        System.out.println("# newNumber: " + newNumber);
    }
}
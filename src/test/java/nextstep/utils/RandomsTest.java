package nextstep.utils;

import org.junit.jupiter.api.Test;

class RandomsTest {

    private final int START_INCLUSIVE = 0;
    private final int END_INCLUSIVE = 9;

    @Test
    public void testPickNumberInRange() {
        int newNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
        System.out.println("# newNumber: " + newNumber);
    }
}
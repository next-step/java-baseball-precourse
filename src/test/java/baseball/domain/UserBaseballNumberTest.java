package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserBaseballNumberTest {

    @Test
    void setUserBaseballNumber() {
        //given
        //when
        List<Integer> actual = UserBaseballNumber.setUserBaseballNumber("123");
        List<Integer> expected = Arrays.asList(1,2,3);

        //then
        assertEquals(expected, actual);
    }
}
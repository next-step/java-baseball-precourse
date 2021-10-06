package baseball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserNumTest {

    @Test
    void isCorrectNum() {
        UserNum userNum = new UserNum("s");
        assertFalse(userNum.isCorrectNum());
    }
    @Test
    void isAcceptableRange() {
        UserNum userNum = new UserNum("11");
        assertFalse(userNum.isCorrectNum());
    }
}
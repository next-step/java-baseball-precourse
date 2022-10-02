package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    @DisplayName("볼, 스트라이크 기록한 그대로 결과가 나온다")
    void test() {
        Result result = new Result();
        result.addBall();
        result.addBall();
        result.addStrike();
        assertEquals("2볼 1스트라이크", result.getResultString());
    }

    @Test
    @DisplayName("볼, 스트라이크 기록이 없으면 낫싱 출력")
    void test2() {
        Result result = new Result();
        assertEquals("낫싱", result.getResultString());
    }
}
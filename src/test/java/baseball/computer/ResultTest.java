package baseball.computer;

import baseball.context.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static baseball.context.ResultType.BALL;
import static baseball.context.ResultType.STRIKE;
import static baseball.util.TestUtil.getPrivateVariable;
import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    @DisplayName("볼 하나가 추가되어야 한다.")
    void addBall() throws IllegalAccessException, NoSuchFieldException {
        Result result = new Result(0, 0);
        result.add(BALL);
        Object ball = getPrivateVariable(result, "ball");
        Object strike = getPrivateVariable(result, "strike");
        assertEquals(1, ball);
        assertEquals(0, strike);
    }

    @Test
    @DisplayName("스트라이크 하나가 추가되어야 한다.")
    void addStrike() throws NoSuchFieldException, IllegalAccessException {
        Result result = new Result(0, 0);
        result.add(STRIKE);
        Object ball = getPrivateVariable(result, "ball");
        Object strike = getPrivateVariable(result, "strike");
        assertEquals(1, strike);
        assertEquals(0, ball);
    }

    @Test
    @DisplayName("볼이 있는지 없는지 검사되어야 한다.")
    void hasBall() {
        Result hasBallResult = new Result(2, 0);
        Result noneBallResult = new Result(0, 0);
        assertTrue(hasBallResult.hasBall());
        assertFalse(noneBallResult.hasBall());
    }

    @Test
    @DisplayName("스트라이크가 있는지 없는지 검사되어야 한다.")
    void hasStrike() {
        Result hasStrikeResult = new Result(0, 2);
        Result noneStrikeResult = new Result(0, 0);
        assertTrue(hasStrikeResult.hasStrike());
        assertFalse(noneStrikeResult.hasStrike());
    }

    @Test
    @DisplayName("볼, 스트라이크가 없다면 낫싱 상태이어야 한다.")
    void nothing() {
        Result hasBallResult = new Result(2, 0);
        Result hasStrikeResult = new Result(0, 2);
        Result result = new Result(0, 0);
        assertTrue(result.nothing());
        assertFalse(hasBallResult.nothing());
        assertFalse(hasStrikeResult.nothing());
    }

    @Test
    @DisplayName("스트라이크가 3개이면 게임이 종료된다.")
    void isPerfect() {
        Result oneStrikeResult = new Result(0, 1);
        Result twoStrikeResult = new Result(0, 2);
        Result threeStrikeResult = new Result(0, 3);
        assertFalse(oneStrikeResult.isPerfect());
        assertFalse(twoStrikeResult.isPerfect());
        assertTrue(threeStrikeResult.isPerfect());
    }
}
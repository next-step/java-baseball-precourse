package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {

    @Test
    @DisplayName("스트라이크 카운트 1 증가 테스트")
    void countStrike_test() {
        //given
        Score score = new Score();
        //when
        score.countStrike();
        //then
        assertEquals(1, score.getStrike(), () -> "countStrike 메서드가 한번 호출되었지만 값이 1이상 올라감.");

    }

    @Test
    @DisplayName("스트라이크와 볼 둘다 0일때 낫싱 여부 확인")
    void isNothing_test() {
        //given
        Score score = new Score();

        //when

        //then
        assertTrue(score.isNothing(), () -> "볼과 스트라이크가 0이지만 낫싱이 false 를 반환");

    }

    @Test
    @DisplayName("스트라이크 카운트 3개 일때 승리인지 확인")
    void isWin_test() {
        Score score = new Score();

        score.countStrike();
        score.countStrike();
        score.countStrike();

        assertTrue(score.isWin(), () -> "스트라이크 카운트가 3번 증가 했지만 승리하지 못함.");
        assertEquals(score.getScoreMessage(), "3스트라이크");

    }

    @Test
    @DisplayName("볼 카운트 1 증가 테스트")
    void countBall_test() {
        //given
        Score score = new Score();
        //when
        score.countBall();
        //then
        assertEquals(1, score.getBall(), () -> "countBall 메서드가 한번 호출되었지만 값이 1이상 올라감.");

    }

    @Test
    @DisplayName("볼 카운트가 있을때 낫싱과 승리가 아닌지 확인")
    void countBall_nothing_win_test() {
        //given
        Score score = new Score();
        //when
        score.countBall();
        //then
        assertAll(() -> {
            assertTrue(score.getBall() > 0);
            assertFalse(score.isNothing());
            assertFalse(score.isWin());
        });

    }

    @Test
    @DisplayName("1볼일때 메세지 테스트")
    void scoreMessage_test() {
        //given
        Score score = new Score();
        //when
        score.countBall();
        //then
        assertAll(() -> {
            assertEquals(1, score.getBall());
            assertEquals(score.getScoreMessage(), "1볼");
        });
    }
}
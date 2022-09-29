package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JudgeTest {

    @DisplayName("Judge 인스턴스 생성시 strike, ball 카운트가 각각 0으로 초기화된다.")
    @Test
    void createJudgeInstance() {
        // given & when
        Judge judge = new Judge();

        int ballCount = judge.getBallCount();
        int strikeCount = judge.getStrikeCount();

        // then
        assertTrue(ballCount == 0);
        assertTrue(strikeCount == 0);
    }

    @DisplayName("strike 카운트 증가 후 getter로 확인할 수 있다.")
    @Test
    void increaseStrikeCount() {
        // given & when
        Judge judge = new Judge();
        judge.increaseStrikeCount();

        // then
        assertTrue(judge.getStrikeCount() == 1);
        assertTrue(judge.getBallCount() == 0);
    }

    @DisplayName("ball 카운트 증가 후 getter로 확인할 수 있다.")
    @Test
    void increaseBallCount() {
        // given & when
        Judge judge = new Judge();
        judge.increaseBallCount();

        // then
        assertTrue(judge.getStrikeCount() == 0);
        assertTrue(judge.getBallCount() == 1);
    }

    @DisplayName("볼카운트 증가 후 resetBallCount로 초기화할 수 있다.")
    @Test
    void resetBallCount() {
        // given & when
        Judge judge = new Judge();
        judge.increaseStrikeCount();
        judge.increaseStrikeCount();
        judge.increaseBallCount();

        judge.resetBallCount();
        // then
        assertTrue(judge.getStrikeCount() == 0);
        assertTrue(judge.getBallCount() == 0);
    }

    @DisplayName("3-strike시 isStrikeOut 함수로 아웃 여부 판정할 수 있다.")
    @Test
    void strikeOut() {
        // given & when
        Judge judge = new Judge();
        for (int i=0; i<3; i++) {
            judge.increaseStrikeCount();;
        }

        // then
        assertTrue(judge.isStrikeOut() == true);
    }
}
package baseball.score;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BaseBallScoreTest {
    BaseBallScore score;

    @BeforeEach
    public void setUp() {
        score = new BaseBallScore();
    }

    @Test
    public void 낫싱_출력_테스트() {
        Assertions.assertEquals("낫싱", score.toString());
    }

    @Test
    void 볼_출력_테스트() {
        score.addBall();
        score.addBall();
        Assertions.assertEquals("볼 2", score.toString());
    }

    @Test
    void 스트라이크_출력_테스트() {
        score.addStrike();
        score.addStrike();
        Assertions.assertEquals("스트라이크 2", score.toString());
    }

    @Test
    void 스트라이크_볼_출력_테스트() {
        score.addStrike();
        score.addBall();
        score.addBall();
        Assertions.assertEquals("스트라이크 1 볼 2", score.toString());
    }

}
package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RandomBallTest {

    private RandomBall randomBall;
    private InputBall inputBall;

    public RandomBallTest() {
        this.randomBall = new RandomBall();
        this.inputBall = new InputBall();
    }

    @Test
    @DisplayName("랜덤볼 생성 확인")
    public void 랜덤볼_생성_확인() throws Exception{
        randomBall.initializeRandomNumbers();
        List<Ball> randomBalls = randomBall.getRandomBalls();
        assertThat(randomBalls.size()).isEqualTo(3);
    }

    @BeforeEach
    void setRandomBall() {
        randomBall.directInitializeRandomNumbers("123");
    }

    @Test
    public void 입력값_매치_성공() throws Exception{
        inputBall.of("123");
        randomBall.matchBalls(inputBall.getBalls());
        assertThat(randomBall.isSuccess()).isTrue();
    }

    @Test
    public void 입력값_매치_실패() throws Exception{
        inputBall.of("234");
        randomBall.matchBalls(inputBall.getBalls());
        assertThat(randomBall.isSuccess()).isFalse();
    }

}
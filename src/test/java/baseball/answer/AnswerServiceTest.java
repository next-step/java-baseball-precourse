package baseball.answer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class AnswerServiceTest {

    private AnswerService answerService;
    private List<Integer> gameAnswer;
    private List<Integer> userAnswer;

    @BeforeEach
    public void initGame() {
        gameAnswer = Arrays.asList(1,2,3);
        answerService = new AnswerService(gameAnswer);
    }

    @Test
    @DisplayName("3스트라이크 테스트")
    void fullStrikeTest() {
        userAnswer = gameAnswer;
        Answer result = answerService.result(userAnswer);
        assertThat(result.getStrike()).isEqualTo(3);
    }

    @Test
    @DisplayName("2스트라이크 테스트")
    void twoStrikeTest() {
        userAnswer = Arrays.asList(1,2,4);
        Answer result = answerService.result(userAnswer);
        assertThat(result.getStrike()).isEqualTo(2);
    }

    @Test
    @DisplayName("1스트라이크 테스트")
    void oneStrikeTest() {
        userAnswer = Arrays.asList(1,4,5);
        Answer result = answerService.result(userAnswer);
        assertThat(result.getStrike()).isEqualTo(1);
    }

    @Test
    @DisplayName("0스트라이크 테스트")
    void zeroStrikeTest() {
        userAnswer = Arrays.asList(4,5,6);
        Answer result = answerService.result(userAnswer);
        assertThat(result.getStrike()).isEqualTo(0);
    }

    @Test
    @DisplayName("3볼 테스트")
    void fullBallTest() {
        userAnswer = Arrays.asList(3,1,2);
        Answer result = answerService.result(userAnswer);
        assertThat(result.getBall()).isEqualTo(3);
    }

    @Test
    @DisplayName("2볼 테스트")
    void twoBallTest() {
        userAnswer = Arrays.asList(3,1,4);
        Answer result = answerService.result(userAnswer);
        assertThat(result.getBall()).isEqualTo(2);
    }

    @Test
    @DisplayName("1볼 테스트")
    void oneBallTest() {
        userAnswer = Arrays.asList(3,4,5);
        Answer result = answerService.result(userAnswer);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    @DisplayName("0볼 테스트")
    void zeroBallTest() {
        userAnswer = Arrays.asList(4,5,6);
        Answer result = answerService.result(userAnswer);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    @DisplayName("1스트라이크 2볼 테스트")
    void oneStrikeTwoBallTest() {
        userAnswer = Arrays.asList(1,3,2);
        Answer result = answerService.result(userAnswer);
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(2);
    }

    @Test
    @DisplayName("게임 정답 리셋 테스트")
    void resetGameAnswerTest() {
        userAnswer = Arrays.asList(4,5,6);
        answerService.resetGameAnswer(userAnswer);
        Answer result = answerService.result(userAnswer);
        assertThat(result.getStrike()).isEqualTo(3);
    }

}
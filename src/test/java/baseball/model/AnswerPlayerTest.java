package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AnswerPlayerTest {
    AnswerPlayer answerPlayer;
    AnswerRandomNumberGenerator answerRandomNumberGenerator;

    @BeforeEach
    public void setUp() {
        answerPlayer = new AnswerPlayer();
        answerRandomNumberGenerator = new AnswerRandomNumberGenerator();
        answerPlayer.setGameNumbers("123");
    }

    @Test
    @DisplayName("추측한 3자리의 숫자가 다 맞아서 게임이 종료되는 테스트")
    public void thinkAnswerRoundHintOrResultSuccessTest() {
        // Given
        RequestHint requestHint = new RequestHint();

        // When
        requestHint.setGameNumbers("123");

        // Then
        assertThat(answerPlayer.thinkAnswerRoundHintOrResult(requestHint).isGameEndFlag())
                .isEqualTo(true)
        ;
    }

    @Test
    @DisplayName("추측한 Ball 카운터가 맞는지 체크하는 테스트")
    public void countingBallTest() {
        // Given
        RequestHint requestHint = new RequestHint();

        // When
        requestHint.setGameNumbers("321");

        // Then
        assertThat(answerPlayer.countingBall(requestHint))
                .isEqualTo(3)
        ;
    }

    @Test
    @DisplayName("추측한 strike 카운터가 맞는지 체크하는 테스트")
    public void countingStrikeTest() {
        // Given
        RequestHint requestHint = new RequestHint();

        // When
        requestHint.setGameNumbers("123");

        // Then
        assertThat(answerPlayer.countingStrike(requestHint))
                .isEqualTo(3)
        ;
    }
}
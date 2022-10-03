package baseball.service;

import static org.assertj.core.api.Assertions.*;

import baseball.model.PlayBase;
import baseball.model.PlayResult;
import baseball.model.UserAnswerRequest;
import baseball.model.UserPlayRequest;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballServiceTest {

    private final BaseballService service;

    BaseballServiceTest() {
        this.service = new BaseballService(new PlayBase());
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "345", "789"})
    @DisplayName("playTest:[success]")
    void playTest(String input) {
        //when
        PlayResult playResult = service.play(UserAnswerRequest.valueOf(input));
        //then
        assertThat(playResult.getAnswer()).containsAnyOf("낫싱", "1스트라이크", "2스트라이크", "3스트라이크", "1볼", "2볼", "3볼",
                "1볼 1스트라이크", "1볼 2스트라이크", "2볼 1스트라이크", "3스트라이크", "게임 종료");
    }

    @ParameterizedTest
    @ValueSource(strings = {"12", "-34", "7890", "-123", "onetwothree"})
    @DisplayName("playExceptionTest (오입력):[success]")
    void playExceptionTest(String input) {
        //when
        UserAnswerRequest userAnswerRequest = UserAnswerRequest.valueOf(input);
        //then
        assertThatThrownBy(() -> service.play(userAnswerRequest))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("playAgainTest:[success]")
    void playAgainTest() {
        //given
        String input = "1";
        //when
        boolean willProceed = service.playAgain(UserPlayRequest.valueOf(input));
        //then
        assertThat(willProceed).isTrue();
    }
}
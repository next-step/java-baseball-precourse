package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserPlayRequestTest {

    @Test
    @DisplayName("isValidNumberTest:[success]")
    void isValidNumberTest() {
        //given
        String input = "1";
        //when
        UserPlayRequest userAnswerRequest = UserPlayRequest.valueOf(input);
        //then
        assertThat(userAnswerRequest.isValidNumber()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"2", "-123", "4567", "onetwothree"})
    @DisplayName("isValidNumberTest:[failure]")
    void isValidNumberExceptionTest(String input) {
        //when
        UserPlayRequest userAnswerRequest = UserPlayRequest.valueOf(input);
        //then
        assertThat(userAnswerRequest.isValidNumber()).isFalse();
    }
}
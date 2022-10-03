package baseball.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserAnswerRequestTest {

    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789"})
    @DisplayName("isValidNumberTest:[success]")
    void isValidNumberTest(String input) {
        UserAnswerRequest userAnswerRequest = UserAnswerRequest.valueOf(input);
        assertThat(userAnswerRequest.isValidNumber()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"-123", "4567", "onetwothree"})
    @DisplayName("isValidNumberTest:[failure]")
    void isValidNumberExceptionTest(String input) {
        UserAnswerRequest userAnswerRequest = UserAnswerRequest.valueOf(input);
        assertThat(userAnswerRequest.isValidNumber()).isFalse();
    }
}
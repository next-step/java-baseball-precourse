package baseball.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserTest {

    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789"})
    void 유저_생성_성공(String s) {
        assertDoesNotThrow(() -> {
            User.of(s);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234", "12345", "012"})
    void 유저_생성_실패(String s) {
        assertThatThrownBy(() -> {
            User.of(s);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
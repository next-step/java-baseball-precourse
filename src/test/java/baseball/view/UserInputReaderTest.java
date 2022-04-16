package baseball.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserInputReaderTest {
    private final UserInputReader reader = new UserInputReader();

    @DisplayName("숫자와 문자를 섞어서 입력한 경우")
    @ParameterizedTest
    @ValueSource(strings = {"12a", "a12", "dd0", "#a1"})
    void notOnlyNumber(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(reader::readBallNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("아무것도 입력하지 않은 경우")
    @Test
    void empty() {
        System.setIn(new ByteArrayInputStream("\n".getBytes()));
        assertThatThrownBy(reader::readBallNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자만 입력한 경우")
    @ParameterizedTest
    @ValueSource(strings = {"12", "123", "1234", "12345"})
    void onlyNumber(String input) {
        int inputLength = input.length();
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        List<Integer> result = reader.readBallNumber();
        assertThat(result.size()).isEqualTo(inputLength);
    }
}
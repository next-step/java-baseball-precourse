package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mockStatic;

class UserInputReaderTest {
    private final UserInputReader reader = new UserInputReader();

    @DisplayName("정답_숫자와 문자를 섞어서 입력한 경우")
    @ParameterizedTest
    @ValueSource(strings = {"12a", "a12", "dd0", "#a1"})
    void notOnlyNumber(String input) {
        try (MockedStatic<Console> mock = mockStatic(Console.class)) {
            mock.when(Console::readLine).thenReturn(input);
            assertThatThrownBy(reader::readBallNumber)
                .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("정답_아무것도 입력하지 않은 경우")
    @Test
    void empty() {
        try (MockedStatic<Console> mock = mockStatic(Console.class)) {
            mock.when(Console::readLine).thenReturn("%n");
            assertThatThrownBy(reader::readBallNumber)
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("정답_숫자만 입력한 경우")
    @ParameterizedTest
    @ValueSource(strings = {"12", "123", "1234", "12345"})
    void onlyNumber(String input) {
        try (MockedStatic<Console> mock = mockStatic(Console.class)) {
            int inputLength = input.length();
            mock.when(Console::readLine).thenReturn(input);
            List<Integer> result = reader.readBallNumber();
            assertThat(result.size()).isEqualTo(inputLength);
        }
    }

    @DisplayName("재시작_1입력 (재시작)")
    @Test
    void restart() {
        try (MockedStatic<Console> mock = mockStatic(Console.class)) {
            mock.when(Console::readLine).thenReturn("1");
            assertThat(reader.readReGameFlag()).isTrue();
        }
    }

    @DisplayName("재시작_2입력 (종료)")
    @Test
    void stop() {
        try (MockedStatic<Console> mock = mockStatic(Console.class)) {
            mock.when(Console::readLine).thenReturn("2");
            assertThat(reader.readReGameFlag()).isFalse();
        }
    }

    @DisplayName("재시작_허용되지않은 값")
    @ParameterizedTest
    @ValueSource(strings = {"a", "123", " ", ""})
    void invalid(String input) {
        try (MockedStatic<Console> mock = mockStatic(Console.class)) {
            mock.when(Console::readLine).thenReturn(input);
            assertThatThrownBy(reader::readReGameFlag)
                .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
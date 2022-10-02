package baseball.util;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

class InputterTest {
    @ParameterizedTest
    @ValueSource(strings = {"1254", "12"})
    void 정답을_맞추기_위해_입력한_길이가_3이_아닐경우_예외발생(String input) {
        try (MockedStatic<Console> consoleMockedStatic = mockStatic(Console.class)) {
            consoleMockedStatic.when(() -> Console.readLine()).thenReturn(input);
            assertThatCode(() -> Inputter.readNumberStringFromUser())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("입력의 길이는 3이어야 합니다.");
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"1+3", "ttt", "!@#"})
    void 정답을_맞추기_위한_입력_중_숫자가_아닌_문자가_있을경우_예외발생(String input) {
        try (MockedStatic<Console> consoleMockedStatic = mockStatic(Console.class)) {
            consoleMockedStatic.when(() -> Console.readLine()).thenReturn(input);
            assertThatCode(() -> Inputter.readNumberStringFromUser())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("숫자만 입력할 수 있습니다.");
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"212", "122", "111"})
    void 정답을_맞추기_위한_입력_중_숫자의_중복이_있을경우_예외발생(String input) {
        try (MockedStatic<Console> consoleMockedStatic = mockStatic(Console.class)) {
            consoleMockedStatic.when(() -> Console.readLine()).thenReturn(input);
            assertThatCode(() -> Inputter.readNumberStringFromUser())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("문자열 내 숫자는 중복될 수 없습니다.");
        }
    }
}

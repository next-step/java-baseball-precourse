package baseball.view;


import static org.assertj.core.api.Assertions.assertThat;

import baseball.constant.GameMessage;
import baseball.validation.GameValidator;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputConsoleTest {

    private InputConsole console;
    private Method method;

    @BeforeEach()
    void setUp() throws Exception {
        console = new InputConsole();
        method = console.getClass().getDeclaredMethod("occursErrorBy", boolean.class);
        method.setAccessible(true);
    }

    @Test
    @DisplayName("사용자 입력 게임 번호가 유효하지 않은 경우 예외 발생")
    void readGameNumbers() throws Exception {
        // given
        boolean isValid = GameValidator.isValidGameNumbers("111");

        try {
            // when
            method.invoke(console, false);
        } catch (InvocationTargetException e) {
            // then
            assertThat(e.getCause().getMessage()).isEqualTo(GameMessage.GAME_ERROR_OUTPUT);
        }
    }

    @Test
    @DisplayName("사용자 입력 재시작번호가 유효하지 않은 경우 예외 발생")
    void readRestartNumber() throws Exception {
        // given
        boolean isValid = GameValidator.isValidRestartNumber("3");

        try {
            // when
            method.invoke(console, false);
        } catch (InvocationTargetException e) {
            // then
            assertThat(e.getCause().getMessage()).isEqualTo(GameMessage.GAME_ERROR_OUTPUT);
        }
    }
}
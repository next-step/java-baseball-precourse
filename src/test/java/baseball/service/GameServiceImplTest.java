package baseball.service;

import baseball.domain.PickNumberMatchResultView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;

import static baseball.AppConfig.getGameService;
import static org.assertj.core.api.Assertions.assertThat;

class GameServiceImplTest {

    GameService gameService = getGameService();

    @DisplayName("입력한 값 유효성 검증")
    @ParameterizedTest(name = "{index}. 입력한 값 유효성 검증 : [{0}]")
    @ValueSource(strings = {"1", "23", "4567", "abc", "ABC", "!@#$%", "123$", "한글입력", "012", ""})
    void isValidReadPickNumberTest(String input) {
        boolean validReadPickNumber = gameService.isValidReadPickNumber(input);
        assertThat(validReadPickNumber).isFalse();
    }

    @DisplayName("숫자만 입력가능 (0 제외)")
    @ParameterizedTest(name = "{index}. 숫자만 입력가능 (0 제외) : [{0}]")
    @ValueSource(strings = {"aaa", "BBB", "!@#","한글테스트", "0", "100"})
    void isValidOnlyNumberTest(String input) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method method = gameService.getClass().getDeclaredMethod("isValidOnlyNumber", String.class);
        method.setAccessible(true);

        boolean result = (boolean) method.invoke(gameService, input);
        assertThat(result).isFalse();
    }

    @DisplayName("자리수 검증")
    @ParameterizedTest(name = "{index}. 자리수 검증 : [{0}]")
    @ValueSource(strings = {"1", "23", "4567"})
    void isValidPickNumberSizeTest(String input) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method method = gameService.getClass().getDeclaredMethod("isValidPickNumberSize", String.class);
        method.setAccessible(true);

        boolean result = (boolean) method.invoke(gameService, input);
        assertThat(result).isFalse();
    }

}
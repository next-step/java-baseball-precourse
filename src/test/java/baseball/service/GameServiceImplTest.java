package baseball.service;

import baseball.controller.GameController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static baseball.AppConfig.getGameController;
import static baseball.AppConfig.getGameService;
import static org.assertj.core.api.Assertions.assertThat;

class GameServiceImplTest {

    GameService gameService = getGameService();

    @DisplayName("입력한 값 유효성 검증 (3자리의 수)")
    @ParameterizedTest
    @ValueSource(strings = {"1", "23", "4567", "abc", "ABC", "!@#$%", "123$", "한글입력", "012", "510"})
    void isValidReadPickNumber(String input) {
        boolean validReadPickNumber = gameService.isValidReadPickNumber(input);
        assertThat(validReadPickNumber).isEqualTo(false);
    }

}